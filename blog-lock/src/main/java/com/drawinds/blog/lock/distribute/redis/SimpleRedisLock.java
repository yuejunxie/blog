package com.drawinds.blog.lock.distribute.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Collections;

/**
 * @author xieyuejun
 * @created 2019/2/25 16:29
 */
public class SimpleRedisLock {

    public static long hold_time = 3000;
    public static ThreadLocal<String> expireHolder = new ThreadLocal<>();

    private static Jedis jedis = new Jedis();

    /**
     * 由于是客户端自己生成过期时间，所以需要强制要求分布式下每个客户端的时间必须同步。
     * <p>
     * 当锁过期的时候，如果多个客户端同时执行jedis.getSet()方法，那么虽然最终只有一个客户端可以加锁，但是这个客户端的锁的过期时间可能被其他客户端覆盖。
     * <p>
     * 锁不具备拥有者标识，即任何客户端都可以解锁。
     * 更为严谨的做法如下：
     * <p>
     * <p>
     * 作者：PIPIONE
     * 链接：https://www.imooc.com/article/34098
     * 来源：慕课网
     *
     * @param lock
     */
    public static void acquire(String lock) {
        //1.先尝试用setnx命令获取锁,key为参数lock,值为当前时间+要持有锁的时间hold_time
        while (jedis.setnx(lock, String.valueOf(System.currentTimeMillis() + hold_time)) == 0) {
            //2.如果获取失败,先watch lock key
            jedis.watch(lock);
            //3.获取当前超时时间
            String expireTime = jedis.get(lock);
            if (expireTime != null && Long.parseLong(expireTime) < System.currentTimeMillis()) {
                //4.如果超时时间小于当前时间,开事务准备更新lock值
                Transaction transaction = jedis.multi();
                Response<String> response = transaction.getSet(lock, String.valueOf(System.currentTimeMillis() + hold_time));
                //5
                // .步骤2设置了watch,如果lock的值被其他线程修改,不是执行事务中的命令
                if (transaction.exec() != null) {
                    String oldExpire = response.get();
                    if (oldExpire != null && Long.parseLong(expireTime) < System.currentTimeMillis()) {
                        //6.如果setget
                        // 命令返回的值依然是过期时间,认为获取锁成功(加了watch之后,这里返回的应该一直是超时时间)
                        break;
                    }
                }
            } else {                //如果key未超时,解除watch
                jedis.unwatch();
            }
        }        //设置客户端超时时间
        expireHolder.set(jedis.get(lock));
    }

    /**
     * 这种方式的问题在于如果调用jedis.del()方法的时候，这把锁已经不属于当前客户端的时候会解除他人加的锁。那么是否真的有这种场景？答案是肯定的，
     * <p>
     * 比如客户端A加锁，一段时间之后客户端A解锁，在执行jedis.del()之前，锁突然过期了，此时客户端B尝试加锁成功，然后客户端A再执行del()方法，则将客户端B的锁给解除了。
     * <p>
     *
     * @param lock
     */
    public static void release(String lock) {        //比较客户端超时时间与lock值,判断是否还由自己持有锁
        if (jedis.get(lock).equals(expireHolder.get())) {
            jedis.del(lock);
        }
        jedis.close();
    }

//

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  客户端标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    //可以看到，我们解锁只需要两行代码就搞定了！第一行代码，我们写了一个简单的Lua脚本代码,第二行代码，我们将Lua代码传到jedis.eval()方法里，并使参数KEYS[1]赋值为lockKey，ARGV[1]赋值为requestId。eval()
    // 方法是将Lua代码交给Redis服务端执行。
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }


}
