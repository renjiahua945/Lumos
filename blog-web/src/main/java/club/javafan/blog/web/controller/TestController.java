package club.javafan.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TestController {

//    @Autowired
//    private SystemUtil systemUtil;
//    @RequestMapping("/test")
//    public ModelAndView test(){
//        ModelAndView modelAndView = new ModelAndView("mail");
//        //获取今日及一个一个月前的日期
//        List<String> dates = systemUtil.getDate(Calendar.DAY_OF_WEEK_IN_MONTH);
//        List<String> pageKeys = systemUtil.genKey(CS_PAGE_VIEW, dates);
//        //获取这段日期的执行次数
//        List<Long> pastDaysPageAmount = systemUtil.getPastDaysAmount(pageKeys);
//        List<String> exKeys = systemUtil.genKey(EXCEPTION_AMOUNT, dates);
//        //获取这段日期的异常次数
//        List<Long> pastDaysExceptionAmount = systemUtil.getPastDaysAmount(exKeys);
//        modelAndView.addObject("exceptionRate",systemUtil.getExceptionRate(pastDaysPageAmount, pastDaysExceptionAmount));
//        modelAndView.addObject("pageData", pastDaysPageAmount);
//        modelAndView.addObject("exceptionData", pastDaysExceptionAmount);
//        modelAndView.addObject("indexDate", dates);
//        modelAndView.addObject("memory", SystemUtil.getMemoryRate());
//        return modelAndView;
//    }

}