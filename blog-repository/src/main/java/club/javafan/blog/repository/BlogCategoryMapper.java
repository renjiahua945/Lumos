package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.domain.BlogCategory;
import club.javafan.blog.domain.example.BlogCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCategoryMapper {
    long countByExample(BlogCategoryExample example);

    int deleteByExample(BlogCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    List<BlogCategory> selectByExample(BlogCategoryExample example);

    BlogCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByExample(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);

    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);
    @Slave
    List<BlogCategory> findCategoryList(PageQueryUtil pageUtil);
    @Slave
    int getTotalCategories(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

}