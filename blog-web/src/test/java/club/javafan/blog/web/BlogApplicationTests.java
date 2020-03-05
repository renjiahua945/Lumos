package club.javafan.blog.web;

import club.javafan.blog.common.constant.RedisKeyConstant;
import club.javafan.blog.common.mail.MailService;
import club.javafan.blog.common.util.DateUtils;
import club.javafan.blog.common.util.RedisUtil;
import club.javafan.blog.repository.BlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Objects;

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
    @Autowired
    private MailService mailService;
    @Test
    public void contextLoads() {
        redisUtil.get("dadad");

        //避免为0为空 加一
        long all = redisUtil.incr(RedisKeyConstant.CS_PAGE_VIEW + DateUtils.getYestoday());
        Object o = redisUtil.get(RedisKeyConstant.EXCEPTION_AMOUNT + DateUtils.getYestoday());
        long exception = Objects.isNull(o) ? 0 : (long)o;
        double rate = exception / (all * 1.0);
        String s = String.format("%.2f", rate) + "%";
        System.out.println(s);
    }


}
