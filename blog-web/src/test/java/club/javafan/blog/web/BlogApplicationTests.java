package club.javafan.blog.web;

import club.javafan.blog.common.util.RedisUtil;
import club.javafan.blog.domain.Blog;
import club.javafan.blog.domain.example.BlogExample;
import club.javafan.blog.repository.BlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static club.javafan.blog.common.constant.RedisKeyConstant.REDIS_DEMO_PRE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private BlogMapper blogMapper;
    @Value("${baidu.content.sensor.app}")
    private String key;
    @Value("${mybatis.mapper-path}")
    private String MAPPER_PATH;

    @Test
    public void contextLoads() {
        BlogExample example = new BlogExample();
        List<Blog> blogs = blogMapper.selectByExample(example);

        System.out.println(blogs);
        redisUtil.set(REDIS_DEMO_PRE,"hello");
        String s = (String) redisUtil.get(REDIS_DEMO_PRE);
        System.out.println(s);
//        System.out.println(MAPPER_PATH);
//        AipContentCensorBuilder.judgeText("草泥马");
    }


}
