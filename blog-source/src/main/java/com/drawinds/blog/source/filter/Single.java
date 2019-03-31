package com.drawinds.blog.source.filter;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/30 23:16
 * Description:
 */
public class Single {

    //    private static Single instance =new Single();
    private static volatile Single instance;

    private Single() {
    }

    private static class SingleHolder {
        static Single instance = new Single();
    }

    public static Single getSingle() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return SingleHolder.instance;
//        return instance;
    }

}
