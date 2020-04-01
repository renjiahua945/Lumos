package club.javafan.blog.common.constant;

import club.javafan.blog.common.annotation.RedisKey;

import static club.javafan.blog.domain.enums.RedisStructureEnum.STRING;
import static club.javafan.blog.domain.enums.RedisStructureEnum.ZSET;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/10 22:55
 * @desc redis Key类 记录所有的redis key 和数据结构
 */
public class RedisKeyConstant {

    @RedisKey(desc = "redis key demo", structure = STRING)
    public static final String REDIS_DEMO_PRE = "redis_demo_pre";

    @RedisKey(desc = "一天controller与service的总调用次数，例如：cs_page_view_2020-02-02", structure = STRING)
    public static final String CS_PAGE_VIEW = "cs_page_view_";

    @RedisKey(desc = "一天异常总量，例如:exception_amount_2020-02-02", structure = STRING)
    public static final String EXCEPTION_AMOUNT = "exception_amount_";

    @RedisKey(desc = "存放用户sessionId,过期时间30分钟", structure = STRING)
    public static final String BLOG_SESSION = "blog_session_";

    @RedisKey(desc = "博客的浏览量 + id", structure = STRING)
    public static final String BLOG_PAGE_VIEW = "blog_page_view_";

    @RedisKey(desc = "博客index的浏览量 + 日期", structure = STRING)
    public static final String BLOG_INDEX_VIEW = "blog_index_view_";

    @RedisKey(desc = "博客index的总浏览量", structure = STRING)
    public static final String BLOG_INDEX_VIEW_ALL = "blog_index_view_all";

    @RedisKey(desc = "博客浏览量的zset，存放博客的id和浏览量", structure = ZSET)
    public static final String BLOG_VIEW_ZSET = "blog_view_zset";

}