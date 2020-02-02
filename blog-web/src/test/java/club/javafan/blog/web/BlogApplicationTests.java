package club.javafan.blog.web;

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
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static club.javafan.blog.common.constant.RedisKeyConstant.CS_PAGE_VIEW;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.math.NumberUtils.LONG_ZERO;

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
        String key = CS_PAGE_VIEW;
        List<String> recentMonthDates = DateUtils.getRecentMonthDates(Calendar.MONTH)
                .stream().map(item -> key + item).collect(Collectors.toList());
        List<Object> objects = redisUtil.mGet(recentMonthDates);
        List<Long> collect = objects.stream().map(item ->
                isNull(item) ? LONG_ZERO : Long.parseLong(String.valueOf(item))).collect(Collectors.toList());
        System.out.println(collect);

    }


}
