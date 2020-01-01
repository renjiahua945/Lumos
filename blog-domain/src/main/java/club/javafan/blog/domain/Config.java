package club.javafan.blog.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Config {
    /**
    * 配置项的名称
    */
    private String configName;

    /**
    * 配置项的值
    */
    private String configValue;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;
}