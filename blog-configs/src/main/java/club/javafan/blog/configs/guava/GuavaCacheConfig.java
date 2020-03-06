package club.javafan.blog.configs.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Guva配置类
 * @author 敲代码的长腿毛欧巴
 * @createDate 2020/3/6
*/
@Configuration
@EnableCaching
public class GuavaCacheConfig {
    private final Logger logger = LoggerFactory.getLogger(GuavaCacheConfig.class);
    /**
     * guava的过期时间设置
     */
    @Value("${guava.time}")
    private Integer time;
    /**
     * guava最大的存储数量
     */
    @Value("${guava.max-size}")
    private Integer maximumSize;

    @Bean
    public Cache<String,Object> guavaCache() {
        return CacheBuilder.newBuilder()
                .initialCapacity(10)
                .maximumSize(maximumSize)
                .recordStats()
                .concurrencyLevel(5)
                .expireAfterWrite(time,TimeUnit.DAYS)
                .removalListener(notification->{
                    logger.info("guava cache key: " + notification.getKey() + "value: " + notification.getValue() + "has been removed!");
                })
                .build();
    }
}