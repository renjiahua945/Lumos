package club.javafan.blog.common.util;

import java.util.HashMap;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/11 21:38
 * @desc 分页插件实体
 */
public class PageQueryUtil extends HashMap<String, Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    public PageQueryUtil(int page,int limit) {
        this.page = page;
        this.limit = limit;
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

    public PageQueryUtil(){};

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
