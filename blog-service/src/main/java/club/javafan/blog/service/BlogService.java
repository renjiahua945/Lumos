package club.javafan.blog.service;


import club.javafan.blog.common.result.ResponseResult;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.common.util.PageResult;
import club.javafan.blog.domain.Blog;
import club.javafan.blog.domain.vo.BlogDetailVO;
import club.javafan.blog.domain.vo.SimpleBlogListVO;

import java.util.List;


public interface BlogService {
    ResponseResult saveBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    int getTotalBlogs();

    /**
     * 根据id获取详情
     *
     * @param blogId
     * @return
     */
    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    ResponseResult updateBlog(Blog blog);

    /**
     * 获取首页文章列表
     *
     * @param cur
     * @param pageSize
     * @return
     */
    PageResult getBlogsForIndexPage(int cur,int pageSize);

    /**
     * 首页侧边栏数据列表
     * 0-点击最多(方法已经作废) 1-最新发布
     *
     * @param type
     * @return
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * 从Redis zSet中拿出前10条热门博文
     *
     * @return
     */
    List<SimpleBlogListVO> getHotBlogs();
    /**
     * 文章详情
     *
     * @param blogId
     * @return
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取文章列表
     *
     * @param tagName
     * @param page
     * @return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryId
     * @param page
     * @return
     */
    PageResult getBlogsPageByCategory(String categoryId, int page);

    /**
     * 根据搜索获取文章列表
     *
     * @param keyword
     * @param page
     * @return
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    BlogDetailVO getBlogDetailBySubUrl(String subUrl);

}
