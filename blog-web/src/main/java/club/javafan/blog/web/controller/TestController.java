//package club.javafan.blog.web.controller;
//
//import club.javafan.blog.common.util.DateUtils;
//import club.javafan.blog.common.util.RedisUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
//import static club.javafan.blog.common.constant.RedisKeyConstant.EXCEPTION_AMOUNT;
//import static java.util.Objects.isNull;
//import static org.apache.commons.collections4.CollectionUtils.isEmpty;
//import static org.apache.commons.lang3.math.NumberUtils.*;
//
//@Controller
//@RequestMapping("")
//public class TestController {
//
//    @Autowired
//    private RedisUtil redisUtil;
//    @RequestMapping("/test")
//    public ModelAndView test(){
//        ModelAndView modelAndView = new ModelAndView("mail");
//        List<String> dates = getDate(Calendar.MONTH);
//        List<String> pageKeys = genKey(CS_PAGE_VIEW, dates);
//        //获取这段日期的执行次数
//        List<Long> pastDaysPageAmount = getPastDaysAmount(pageKeys);
//        List<String> exKeys = genKey(EXCEPTION_AMOUNT, dates);
//        //获取这段日期的异常次数
//        List<Long> pastDaysExceptionAmount = getPastDaysAmount(exKeys);
//        modelAndView.addObject("exceptionRate",getExceptionRate(pastDaysPageAmount, pastDaysExceptionAmount));
//        modelAndView.addObject("pageData", pastDaysPageAmount);
//        modelAndView.addObject("exceptionData", pastDaysExceptionAmount);
//        modelAndView.addObject("indexDate", dates);
//        return modelAndView;
//
//    }
//    /**
//     * 计算异常率
//     *
//     * @param pastDaysPageAmount      最近日期的访问量
//     * @param pastDaysExceptionAmount 最近日期的异常量
//     * @return 异常率的list
//     */
//    private List<Double> getExceptionRate(List<Long> pastDaysPageAmount, List<Long> pastDaysExceptionAmount) {
//        if (isEmpty(pastDaysExceptionAmount) || isEmpty(pastDaysExceptionAmount)) {
//            return new ArrayList<>(1);
//        }
//        List<Double> res = new ArrayList<>(pastDaysPageAmount.size());
//        for (int i = 0; i < pastDaysPageAmount.size(); i++) {
//            Long past = pastDaysPageAmount.get(i);
//            if (LONG_ZERO.equals(past)) {
//                res.add(DOUBLE_ZERO);
//                continue;
//            }
//            Long ex = pastDaysExceptionAmount.get(i);
//            double re = ex / past * DOUBLE_ONE;
//            String s = String.format("%.2f", re);
//            res.add(Double.parseDouble(s));
//        }
//        return res;
//    }
//
//    /**
//     * 获取昨天的总访问量
//     *
//     * @return
//     */
//    private long getPassView() {
//        Object o1 = redisUtil.get(CS_PAGE_VIEW + DateUtils.getYestoday());
//        long all = isNull(o1) ? LONG_ONE : Long.parseLong(o1.toString());
//        return all;
//    }
//
//    /**
//     * 获取最近一个月数据
//     *
//     * @return List<Long>
//     */
//    private List<Long> getPastDaysAmount(List<String> keys) {
//        List<Object> objects = redisUtil.mGet(keys);
//        List<Long> collect = objects.stream().map(item ->
//                isNull(item) ? LONG_ZERO : Long.parseLong(String.valueOf(item))).collect(Collectors.toList());
//        return collect;
//    }
//
//    /**
//     * 生成redisKey list 前缀与日期拼接
//     *
//     * @param redisKey redisKey 前缀
//     * @return List<String>
//     */
//    private List<String> genKey(String redisKey, List<String> recentDates) {
//        return recentDates.stream().map(item -> redisKey + item).collect(Collectors.toList());
//    }
//
//    /**
//     * 获取一段日期
//     *
//     * @param type 类型
//     * @return 日志列表
//     */
//    private List<String> getDate(int type) {
//        return DateUtils.getRecentMonthDates(type);
//    }
//}