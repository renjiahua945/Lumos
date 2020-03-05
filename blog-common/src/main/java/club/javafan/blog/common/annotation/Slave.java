package club.javafan.blog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/8 9:53
 * @desc 自定义注解，主要是为了做切点用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Slave {
}
