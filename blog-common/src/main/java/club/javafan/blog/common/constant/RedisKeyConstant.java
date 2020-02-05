package club.javafan.blog.common.constant;

import club.javafan.blog.common.annotation.RedisKey;

import static club.javafan.blog.domain.enums.RedisStructureEnum.STRING;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/10 22:55
 * @desc redis Key类 记录所有的redis key 和数据结构
 */
public class RedisKeyConstant {

    @RedisKey(desc = "redis key demo", structure = STRING)
    public static final String REDIS_DEMO_PRE = "redis_demo_pre";

    @RedisKey(desc = "一天controller与service的总访问次数，例如：cs_page_view_2020-02-02", structure = STRING)
    public static final String CS_PAGE_VIEW = "cs_page_view_";

    @RedisKey(desc = "一天异常总量，例如:exception_amount_2020-02-02", structure = STRING)
    public static final String EXCEPTION_AMOUNT = "exception_amount_";

}