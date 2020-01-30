package club.javafan.blog.common.mail.impl;

import club.javafan.blog.common.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author 不会敲代码的小白
 * @date 2020/1/30
 * 邮件发送类
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    /**
     * 用户名
     */
    @Value("${spring.mail.username}")
    private String from;
    /**
     * JavaMail邮件发送服务
     */
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom("不会敲代码的小白" + "<" + from + ">");
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = buildHelper(to, subject, content, message);
        mailSender.send(message);
    }


    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = buildHelper(to, subject, content, message);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = file.getFilename();
        //添加附件，可多次调用该方法添加多个附件
        helper.addAttachment(fileName, file);
        mailSender.send(message);

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = buildHelper(to, subject, content, message);
        FileSystemResource res = new FileSystemResource(new File(rscPath));
        //重复使用添加多个图片
        helper.addInline(rscId, res);
        mailSender.send(message);

    }

    private MimeMessageHelper buildHelper(String to, String subject, String content, MimeMessage message) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        message.setFrom("不会敲代码的小白" + "<" + from + ">");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        return helper;
    }
}
