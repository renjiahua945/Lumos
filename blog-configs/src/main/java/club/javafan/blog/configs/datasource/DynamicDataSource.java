package club.javafan.blog.configs.datasource;


import club.javafan.blog.common.util.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/8 9:48
 * @desc 获取当前数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
