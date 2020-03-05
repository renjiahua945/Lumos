package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BlogComment {
    /**
    * 主键id
    */
    private Long commentId;

    /**
    * 关联的blog主键
    */
    private Long blogId;

    /**
    * 评论者名称
    */
    private String commentator;

    /**
    * 评论人的邮箱
    */
    private String email;
    /**
     * 评论人qq号
     */
    private String qNumber;
    /**
     * 评论人昵称
     */
    private String nickName;
    /**
     *  评论人头像
     */
    private String headImg;
    /**
    * 网址
    */
    private String websiteUrl;

    /**
    * 评论内容
    */
    private String commentBody;

    /**
    * 评论提交时间
    */
    private Date commentCreateTime;

    /**
    * 评论时的ip地址
    */
    private String commentatorIp;

    /**
    * 回复内容
    */
    private String replyBody;

    /**
    * 回复时间
    */
    private Date replyCreateTime;

    /**
    * 是否审核通过 0-未审核 1-审核通过
    */
    private Byte commentStatus;

    /**
    * 是否删除 0-未删除 1-已删除
    */
    private Byte isDeleted;
}