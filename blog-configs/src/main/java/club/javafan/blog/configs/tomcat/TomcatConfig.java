package club.javafan.blog.configs.tomcat;

import org.apache.catalina.Context;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author 敲代码的长腿毛欧巴
 * @date 2020/2/1
 * @desc tomcat配置(SpringBoot 内置tomcat 需要调优)
 */
@SpringBootConfiguration
public class TomcatConfig {
    /**
     * 启动的http port
     */
    @Value("${http.port}")
    Integer httpPort;
    /**
     * 服务器正常工作的port
     */
    @Value("${server.port}")
    Integer httpsPort;

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        //设置端口号
        tomcat.setPort(httpPort);
        //factory这个对象中还有很多的Spring容器级别的参数可以设置，例如我们前几篇文章中讲到的Initializers、Listeners、Tomcat日志等
        //设置Tomcat连接池...
        //这是以java8的做法来实现的，事实上就是编写一个内部类，不熟悉Java8的读者可以借鉴下面的实现方式
        tomcat.addConnectorCustomizers((connector -> {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setMaxThreads(300);
            protocol.setMaxConnections(1000);
            //监听到http的端口号后转向到的https的端口号
            connector.setRedirectPort(httpsPort);
            connector.setScheme("http");
            //Connector监听的http的端口号
            connector.setSecure(false);
        }));
        return tomcat;
    }
}
