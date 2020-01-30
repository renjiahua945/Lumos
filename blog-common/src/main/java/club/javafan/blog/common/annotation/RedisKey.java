package club.javafan.blog.common.annotation;

import club.javafan.blog.domain.enums.RedisStructureEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/8 12:46
 * @desc redis key的结构注释 仅存在源码
 */
@Retention(RetentionPolicy.SOURCE)
public @interface RedisKey {
    //redis key 的描述
    String desc();
    //redis 的数据结构
    RedisStructureEnum structure();
}
