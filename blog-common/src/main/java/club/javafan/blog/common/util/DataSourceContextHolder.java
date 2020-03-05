package club.javafan.blog.common.util;

import club.javafan.blog.domain.enums.DataSourceEnum;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/8 9:34
 * @desc 数据源保存holder
 */
public class DataSourceContextHolder {
    /**
     * 数据源context
     */
    private static ThreadLocal<DataSourceEnum> context = new ThreadLocal<>();

    /**
     * 获取当前的数据源
     *
     * @return DataSourceEnum
     */
    public static DataSourceEnum get() {
        return context.get();
    }

    /**
     * 设置当前的数据源
     *
     * @param dataSourceEnum
     */
    public static void set(DataSourceEnum dataSourceEnum) {
        context.set(dataSourceEnum);
    }

    /**
     * 移除
     */
    public static void remove() {
        context.remove();
    }
}