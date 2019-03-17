package com.blog.drawinds.agent;

import java.lang.management.*;
import java.util.List;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/12 21:27
 * Description:
 */
public class AgentAppliactiion {

    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        memoryMXBean.gc();
        List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
        memoryManagerMXBeans.forEach(memoryManagerMXBean -> memoryManagerMXBean.getMemoryPoolNames());
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        threadMXBean.dumpAllThreads(false, false);
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.forEach(garbageCollectorMXBean -> garbageCollectorMXBean.getCollectionCount());

    }
}
