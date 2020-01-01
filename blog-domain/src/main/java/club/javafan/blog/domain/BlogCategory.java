package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BlogCategory {
    /**
    * 分类表主键
    */
    private Integer categoryId;

    /**
    * 分类的名称
    */
    private String categoryName;

    /**
    * 分类的图标
    */
    private String categoryIcon;

    /**
    * 分类的排序值 被使用的越多数值越大
    */
    private Integer categoryRank;

    /**
    * 是否删除 0=否 1=是
    */
    private Byte isDeleted;

    /**
    * 创建时间
    */
    private Date createTime;
}