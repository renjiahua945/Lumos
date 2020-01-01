package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.domain.BlogTag;
import club.javafan.blog.domain.BlogTagCount;
import club.javafan.blog.domain.example.BlogTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagMapper {
    long countByExample(BlogTagExample example);

    int deleteByExample(BlogTagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    List<BlogTag> selectByExample(BlogTagExample example);

    BlogTag selectByPrimaryKey(Integer tagId);

    int updateByExampleSelective(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByExample(@Param("record") BlogTag record, @Param("example") BlogTagExample example);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);
    @Slave
    List<BlogTag> findTagList(PageQueryUtil pageUtil);
    @Slave
    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    int batchInsertBlogTag(List<BlogTag> tagList);
    @Slave
    List<BlogTagCount> getTagCount();

}