package club.javafan.blog.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @author 不会敲代码的小白
 * @createDate 2020/1/30
 */
public class DateUtils {

    /**
     * 获取今天
     *
     * @return String
     */
    public static String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取昨天
     *
     * @return String
     */
    public static String getYestoday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取当前日期前一个月、前一星期的日期集合
     *
     * @param type Calendar.MONTH(前一个月)
     *             Calendar.DAY_OF_MONTH(本月开始的日期)
     *             Calendar.DAY_OF_WEEK_IN_MONTH(含今天前一星期)
     * @return
     */
    public static List<String> getRecentMonthDates(int type) {
        Calendar begin = Calendar.getInstance();
        begin.setTime(new Date());
        // 月份，星期，工作日
        begin.add(type, -1);
        // 日期加1
        begin.add(Calendar.DATE, +1);
        Date result = begin.getTime();
        Calendar end = Calendar.getInstance();
        Long startTime = begin.getTimeInMillis();
        Long endTime = end.getTimeInMillis();
        List dates = new ArrayList<>();
        while (startTime <= endTime) {
            Date d = new Date(startTime);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            dates.add(df.format(d));
            begin.add(Calendar.DATE, +1);
            startTime = begin.getTimeInMillis();
        }
        return dates;
    }

    /**
     * 获取本月开始日期
     *
     * @return String
     */
    public static String getMonthStart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本月最后一天
     *
     * @return String
     */
    public static String getMonthEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本周的第一天
     *
     * @return String
     */
    public static String getWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本周的最后一天
     *
     * @return String
     */
    public static String getWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本年的第一天
     *
     * @return String
     */
    public static String getYearStart() {
        return new SimpleDateFormat("yyyy").format(new Date()) + "-01-01";
    }

    /**
     * 获取本年的最后一天
     *
     * @return String
     */
    public static String getYearEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast);
    }

}