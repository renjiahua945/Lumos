package club.javafan.blog.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilterConfig implements WebMvcConfigurer {
    @Value("${file.file-path}")
    private String FILE_PATH;
    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login").excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 路径映射
        String path = System.getProperty("user.dir").replaceAll("\\\\", "/") + FILE_PATH;
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + path);
    }

}