package com.drawinds.blog.enterprise.hystrix;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/7 13:58
 * Description:
 */
public class GetUserServiceCommand{
//        extends HystrixCommand<String> {
//
//    public GetUserServiceCommand() {
//        super(setter());
//    }
//
//    private static Setter setter() {
//        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("user");
//        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("getUserInfo");
//        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("user_pool");
//        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter().withCoreSize(10).withKeepAliveTimeMinutes(5)
//                .withMaxQueueSize(16).withQueueSizeRejectionThreshold(10);
//        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
//        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThreadPoolKey(threadPoolKey).andThreadPoolPropertiesDefaults(threadPoolProperties).andCommandPropertiesDefaults(commandProperties);
//    }
//
//    @Override
//    protected String run() throws Exception {
//        return null;
//    }
}
