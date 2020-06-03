package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BlogLink {
    /**
     * 友链表主键id
     */
    private Integer linkId;

    /**
     * 友链类别 0-友链 1-推荐 2-个人网站
     */
    private Byte linkType;

    /**
     * 网站名称
     */
    private String linkName;

    /**
     * 网站链接
     */
    private String linkUrl;

    /**
     * 网站描述
     */
    private String linkDescription;
    /**
     * 网站logo
     */
    private String linkLogo;
    /**
     * 用于列表排序
     */
    private Integer linkRank;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    private Byte isDeleted;

    /**
     * 添加时间
     */
    private Date createTime;
}