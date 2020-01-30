package club.javafan.blog.common.util;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * @author 不会敲代码的小白
 * @date 2020/1/30
 * 系统操作工具类
 */
public class SystemUtil {
    /**
     * 查看系统内存使用率
     *
     * @return
     */
    public static String getMemoryRate() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        // 剩余的物理内存
        long totalVirtualMemory = operatingSystemMXBean.getTotalSwapSpaceSize();
        long freePhysicalMemorySize = operatingSystemMXBean.getFreePhysicalMemorySize();
        Double compare = (1 - freePhysicalMemorySize * 1.0 / totalVirtualMemory) * 100;
        String str = compare.intValue() + "%";
        return str;
    }
}
