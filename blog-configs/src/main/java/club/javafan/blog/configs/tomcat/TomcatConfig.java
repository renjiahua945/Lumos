package club.javafan.blog.configs.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
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
        //tomcat.setPort(httpPort);
        //factory这个对象中还有很多的Spring容器级别的参数可以设置，例如我们前几篇文章中讲到的Initializers、Listeners、Tomcat日志等
        //设置Tomcat连接池...
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocolHandler = (Http11NioProtocol) connector.getProtocolHandler();
        protocolHandler.setMaxThreads(300);
        protocolHandler.setMaxConnections(1000);
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }


}
