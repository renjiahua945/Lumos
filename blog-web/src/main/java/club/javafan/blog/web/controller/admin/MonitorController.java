package club.javafan.blog.web.controller.admin;

import club.javafan.blog.common.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.List;

import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
import static club.javafan.blog.common.constant.RedisKeyConstant.EXCEPTION_AMOUNT;

/**
 * 监控controller
 *
 * @author 敲代码的长腿毛欧巴
 * @date 2020/2/2
 */
@Controller
@RequestMapping("/admin")
public class MonitorController {
    @Autowired
    private SystemUtil systemUtil;

    @RequestMapping("/blogs/monitor")
    public ModelAndView doMonitor() {
        ModelAndView modelAndView = new ModelAndView("admin/monitor");
        //获取最近一个月的日期
        List<String> indexDate = systemUtil.getDate(Calendar.MONTH);
        //生成最近一个月的key
        List<String> pKeys = systemUtil.genKey(CS_PAGE_VIEW, indexDate);
        //获取最近一个月的访问量
        List<Long> pastDaysPageAmount = systemUtil.getPastDaysAmount(pKeys);
        //获取最近一个与的异常key
        List<String> exceptionKeys = systemUtil.genKey(EXCEPTION_AMOUNT, indexDate);
        //获取过去一个月的异常数
        List<Long> pastDaysExceptionAmount = systemUtil.getPastDaysAmount(exceptionKeys);
        modelAndView.addObject("exceptionRate", systemUtil.getExceptionRate(pastDaysPageAmount, pastDaysExceptionAmount));
        modelAndView.addObject("pageData", pastDaysPageAmount);
        modelAndView.addObject("exceptionData", pastDaysExceptionAmount);
        modelAndView.addObject("indexDate", indexDate);
        return modelAndView;
    }


}
