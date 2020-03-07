package club.javafan.blog.worker;

import club.javafan.blog.common.mail.MailService;
import club.javafan.blog.common.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
import static club.javafan.blog.common.constant.RedisKeyConstant.EXCEPTION_AMOUNT;


/**
 * @author 敲代码的长腿毛欧巴
 * @date 2020/1/30
 * 定时发送邮件类(如果是集群，应该加上分布式锁)
 */

@Configuration
@EnableScheduling
@EnableAsync
public class SendMail {
    /**
     * 发送邮件服务
     */
    @Autowired
    private MailService mailService;
    /**
     * Thymeleaf模板引擎
     */
    @Autowired
    private TemplateEngine templateEngine;
    /**
     * 接收邮件者
     */
    @Value("${spring.mail.to}")
    private String to;

    @Value("#{'${spring.mail.cc}'.split(',')}")
    private String[] cc;
    /**
     * 邮件主题
     */
    @Value("${spring.mail.subject}")
    private String subject;
    /**
     * redis 工具类
     */
    @Autowired
    private SystemUtil systemUtil;

    /**
     * 定时发送博客日报(每天18点) 注意cron 必须是6、7位
     *
     * @throws MessagingException
     */
    @Scheduled(cron = "0 0 18 * * ?")
    @Async("threadTaskExecutor")
    public void sendMailScheduled() throws MessagingException {
        Map<String, Object> valueMap = new HashMap<>(5);
        //获取今日及一个一个月前的日期
        List<String> dates = systemUtil.getDate(Calendar.DAY_OF_WEEK_IN_MONTH);
        List<String> pageKeys = systemUtil.genKey(CS_PAGE_VIEW, dates);
        //获取这段日期的执行次数
        List<Long> pastDaysPageAmount = systemUtil.getPastDaysAmount(pageKeys);
        List<String> exKeys = systemUtil.genKey(EXCEPTION_AMOUNT, dates);
        //获取这段日期的异常次数
        List<Long> pastDaysExceptionAmount = systemUtil.getPastDaysAmount(exKeys);
        //获取系统的现在占用率
        valueMap.put("memory", systemUtil.getMemoryRate());
        //获取系统的异常率
        valueMap.put("exceptionRate", systemUtil.getExceptionRate(pastDaysPageAmount, pastDaysExceptionAmount));
        valueMap.put("pageData", pastDaysPageAmount);
        valueMap.put("exceptionData", pastDaysExceptionAmount);
        valueMap.put("indexDate", dates);
        doSendHtmlMail(valueMap);
    }

    /**
     * 发送模板邮件
     *
     * @param valueMap 模板邮件的值
     * @throws MessagingException
     */
    private void doSendHtmlMail(Map<String, Object> valueMap) throws MessagingException {
        Context context = new Context();
        context.setVariables(valueMap);
        String content = this.templateEngine.process("mail", context);
        mailService.sendHtmlMail(to, subject, content, cc);
    }

}
