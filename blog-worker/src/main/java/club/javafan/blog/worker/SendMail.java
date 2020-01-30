package club.javafan.blog.worker;

import club.javafan.blog.common.constant.RedisKeyConstant;
import club.javafan.blog.common.mail.MailService;
import club.javafan.blog.common.util.DateUtils;
import club.javafan.blog.common.util.RedisUtil;
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
import java.util.HashMap;
import java.util.Map;

import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.math.NumberUtils.*;


/**
 * @author 不会敲代码的小白
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
    /**
     * 邮件主题
     */
    @Value("${spring.mail.subject}")
    private String subject;
    /**
     * redis 工具类
     */
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 定时发送博客日报(每天18点) 注意cron 必须是6位
     *
     * @throws MessagingException
     */
    @Scheduled(cron = "0 0 18 * * ?")
    @Async("threadTaskExecutor")
    public void sendMailScheduled() throws MessagingException {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("memory", SystemUtil.getMemoryRate());
        valueMap.put("exception", getExceptionRate());
        valueMap.put("all", getPassView());
        doSendHtmlMail(valueMap);
    }

    private void doSendHtmlMail(Map<String, Object> valueMap) throws MessagingException {
        Context context = new Context();
        context.setVariables(valueMap);
        String content = this.templateEngine.process("mail", context);
        mailService.sendHtmlMail(to, subject, content);
    }

    /**
     * 获取昨日的异常率
     *
     * @author 不会敲代码的小白
     * @createDate 2020/1/30
     */
    private String getExceptionRate() {
        //避免为0为空 加一
        Object o1 = redisUtil.get(CS_PAGE_VIEW + DateUtils.getYestoday());
        long all = isNull(o1) ? LONG_ONE : Long.parseLong(o1.toString());
        Object o = redisUtil.get(RedisKeyConstant.EXCEPTION_AMOUNT + DateUtils.getYestoday());
        long exception = isNull(o) ? LONG_ZERO : Long.parseLong(o1.toString());
        double rate = exception / (all * DOUBLE_ONE);
        return String.format("%.2f", rate) + "%";
    }

    /**
     * 获取昨天的总访问量
     *
     * @return
     */
    private long getPassView() {
        Object o1 = redisUtil.get(CS_PAGE_VIEW + DateUtils.getYestoday());
        long all = isNull(o1) ? LONG_ONE : Long.parseLong(o1.toString());
        return all;
    }
}
