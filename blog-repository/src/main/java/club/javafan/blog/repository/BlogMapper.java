package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.domain.Blog;
import club.javafan.blog.domain.example.BlogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);
    int updateByPrimaryKey(Blog record);

    @Slave
    List<Blog> findBlogList(PageQueryUtil pageUtil);
    @Slave
    int getTotalBlogs(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
    @Slave
    int getTotalBlogsByTagId(PageQueryUtil pageUtil);
    @Slave
    List<Blog> getBlogsPageByTagId(PageQueryUtil pageUtil);

    int updateBlogCategorys(@Param("categoryName") String categoryName, @Param("categoryId") Integer categoryId, @Param("ids")Integer[] ids);


}