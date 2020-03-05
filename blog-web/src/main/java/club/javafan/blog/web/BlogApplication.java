package club.javafan.blog.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("club.javafan.blog.repository")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({
        "club.javafan.blog.service"
        , "club.javafan.blog.web.controller"
        , "club.javafan.blog.web.aop"
        , "club.javafan.blog.web.filter"
        , "club.javafan.blog.configs"
        , "club.javafan.blog.common.util"
        , "club.javafan.blog.common.mail.impl"
        , "club.javafan.blog.common.threadpool"
        , "club.javafan.blog.common.qquserinfo"
        , "club.javafan.blog.worker"
})
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
