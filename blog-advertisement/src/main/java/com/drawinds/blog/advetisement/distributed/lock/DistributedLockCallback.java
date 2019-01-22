package com.drawinds.blog.advetisement.distributed.lock;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 20:30
 * Description:
 */
public interface DistributedLockCallback<T> {

    T process();

    String getLockName();
}
