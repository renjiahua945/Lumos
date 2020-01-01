package club.javafan.blog.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BlogTag {
    /**
    * 标签表主键id
    */
    private Integer tagId;

    /**
    * 标签名称
    */
    private String tagName;

    /**
    * 是否删除 0=否 1=是
    */
    private Byte isDeleted;

    /**
    * 创建时间
    */
    private Date createTime;
}