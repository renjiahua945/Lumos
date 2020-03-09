package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.domain.BlogComment;
import club.javafan.blog.domain.example.BlogCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogCommentMapper {
    long countByExample(BlogCommentExample example);

    int deleteByExample(BlogCommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    List<BlogComment> selectByExample(BlogCommentExample example);

    BlogComment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByExample(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
    @Slave
    List<BlogComment> findBlogCommentList(Map map);
    @Slave
    int getTotalBlogComments(Map map);
    @Slave
    int checkDone(Integer[] ids);

    int deleteBatch(Integer[] ids);

    int deleteBatchByBlogId(Integer[] ids);
}