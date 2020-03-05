package club.javafan.blog.common.mail;

import javax.mail.MessagingException;

/**
 * 邮件服务
 *
 * @author 敲代码的长腿毛欧巴
 * @createDate 2020/2/2
 */
public interface MailService {
    /**
     * 发送普通文本邮件
     *  @param to      收件人
     * @param subject 主题
     * @param content 内容
     * @param cc
     */
    void sendSimpleMail(String to, String subject, String content, String[] cc);

    /**
     * 发送HTML邮件
     *  @param to      收件人
     * @param subject 主题
     * @param content 内容（可以包含<html>等标签）
     * @param cc
     */
    void sendHtmlMail(String to, String subject, String content, String[] cc) throws MessagingException;

    /**
     * 发送带附件的邮件
     *  @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件路径
     * @param cc
     */
    void sendAttachmentMail(String to, String subject, String content, String filePath, String[] cc) throws MessagingException;

    /**
     * 发送带图片的邮件
     *  @param to      收件人
     * @param subject 主题
     * @param content 文本
     * @param rscPath 图片路径
     * @param rscId   图片ID，用于在<img>标签中使用，从而显示图片
     * @param cc
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId, String[] cc) throws MessagingException;

}