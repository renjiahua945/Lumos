package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BlogTagRelation {
    /**
    * 关系表id
    */
    private Long relationId;

    /**
    * 博客id
    */
    private Long blogId;

    /**
    * 标签id
    */
    private Integer tagId;

    /**
    * 添加时间
    */
    private Date createTime;
}