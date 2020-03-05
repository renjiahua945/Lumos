package club.javafan.blog.common.threadpool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/10 22:52
 * @desc 创建线程池(队列满了使用默认策略抛出异常)
 */
@Configuration
@EnableAsync
public class ThreadTaskExecutorConfig {
    @Value("${thread.core-pool-size}")
    private Integer coreSize;
    @Value("${thread.max-pool-size}")
    private Integer maxSize;
    @Value("${thread.queue-capacity}")
    private Integer queueCapacity;
    @Value("${thread.keep-alive-seconds}")
    private Integer keepAlive;
    @Value("${thread.allow-coreThread-timeOut}")
    private Boolean allowTimeOut;

    @Bean
    public Executor threadTaskExecutor() {
        return createExecutor();
    }

    private Executor createExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(maxSize);
        executor.setAllowCoreThreadTimeOut(allowTimeOut);
        executor.setThreadNamePrefix("schedule-mail-post-pool-");
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAlive);
        executor.initialize();
        return executor;
    }
}