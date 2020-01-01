package club.javafan.blog.common.constant;

import club.javafan.blog.common.annotation.RedisKey;
import club.javafan.blog.domain.enums.RedisStructureEnum;
/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/10 22:55
 * @desc redis Key类 记录所有的redis key 和数据结构
 */
public class RedisKeyConstant {

    @RedisKey(desc = "redis key demo", structure = RedisStructureEnum.STRING)
    public static String REDIS_DEMO_PRE = "redis_demo_pre";
}