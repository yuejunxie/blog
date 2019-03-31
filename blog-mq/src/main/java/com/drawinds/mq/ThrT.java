package com.drawinds.mq;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/20 21:52
 * Description:
 */
public class ThrT {

    private static VO vo = new VO();

    static ThreadLocal<VO> threadLocal = ThreadLocal.withInitial(() -> vo);

    static class VO {
        int i = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    VO vo = threadLocal.get();
                    System.out.println(vo.i);
                    vo.i = vo.i + 1;
                    threadLocal.set(vo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(threadLocal.get().i);
    }
}
