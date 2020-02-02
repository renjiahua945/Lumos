package club.javafan.blog.common.util;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
import static java.util.Objects.isNull;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.lang3.math.NumberUtils.*;

/**
 * @author 不会敲代码的小白
 * @date 2020/1/30
 * 系统操作工具类
 */
@Component
public class SystemUtil {
    @Autowired
    private RedisUtil redisUtil;
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

    /**
     * 计算异常率
     *
     * @param pastDaysPageAmount      最近日期的访问量
     * @param pastDaysExceptionAmount 最近日期的异常量
     * @return 异常率的list
     */
    public List<Double> getExceptionRate(List<Long> pastDaysPageAmount, List<Long> pastDaysExceptionAmount) {
        if (isEmpty(pastDaysExceptionAmount) || isEmpty(pastDaysExceptionAmount)) {
            return new ArrayList<>(1);
        }
        List<Double> res = new ArrayList<>(pastDaysPageAmount.size());
        for (int i = 0; i < pastDaysPageAmount.size(); i++) {
            Long past = pastDaysPageAmount.get(i);
            if (LONG_ZERO.equals(past)) {
                res.add(DOUBLE_ZERO);
                continue;
            }
            Long ex = pastDaysExceptionAmount.get(i);
            double re = ex / past * DOUBLE_ONE;
            String s = String.format("%.2f", re);
            res.add(Double.parseDouble(s));
        }
        return res;
    }

    /**
     * 获取昨天的总访问量
     *
     * @return
     */
    public long getPassView() {
        Object o1 = redisUtil.get(CS_PAGE_VIEW + DateUtils.getYestoday());
        long all = isNull(o1) ? LONG_ONE : Long.parseLong(o1.toString());
        return all;
    }

    /**
     * 获取最近一个月数据
     *
     * @return List<Long>
     */
    public List<Long> getPastDaysAmount(List<String> keys) {
        List<Object> objects = redisUtil.mGet(keys);
        List<Long> collect = objects.stream().map(item ->
                isNull(item) ? LONG_ZERO : Long.parseLong(String.valueOf(item))).collect(Collectors.toList());
        return collect;
    }

    /**
     * 生成redisKey list 前缀与日期拼接
     *
     * @param redisKey redisKey 前缀
     * @return List<String>
     */
    public List<String> genKey(String redisKey, List<String> recentDates) {
        return recentDates.stream().map(item -> redisKey + item).collect(Collectors.toList());
    }

    /**
     * 获取一段日期
     *
     * @param type 类型
     * @return 日志列表
     */
    public List<String> getDate(int type) {
        return DateUtils.getRecentMonthDates(type);
    }
}
