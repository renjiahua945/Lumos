package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    /**
    * 博客表主键id
    */
    private Long blogId;

    /**
    * 博客标题
    */
    private String blogTitle;

    /**
    * 博客自定义路径url
    */
    private String blogSubUrl;

    /**
    * 博客封面图
    */
    private String blogCoverImage;

    /**
    * 博客内容
    */
    private String blogContent;

    /**
    * 博客分类id
    */
    private Integer blogCategoryId;

    /**
    * 博客分类(冗余字段)
    */
    private String blogCategoryName;

    /**
    * 博客标签
    */
    private String blogTags;

    /**
    * 0-草稿 1-发布
    */
    private Byte blogStatus;

    /**
     * 阅读量（已经废弃）
    */
    private Long blogViews;

    /**
    * 0-允许评论 1-不允许评论
    */
    private Byte enableComment;

    /**
    * 是否删除 0=否 1=是
    */
    private Byte isDeleted;

    /**
    * 添加时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;
}