package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Master;
import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.domain.BlogTagRelation;
import club.javafan.blog.domain.example.BlogTagRelationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlogTagRelationMapper {
    long countByExample(BlogTagRelationExample example);

    @Async("threadTaskExecutor")
    int deleteByExample(BlogTagRelationExample example);

    int deleteByPrimaryKey(Long relationId);

    int insert(BlogTagRelation record);

    int insertSelective(BlogTagRelation record);

    List<BlogTagRelation> selectByExample(BlogTagRelationExample example);

    BlogTagRelation selectByPrimaryKey(Long relationId);

    int updateByExampleSelective(@Param("record") BlogTagRelation record, @Param("example") BlogTagRelationExample example);

    int updateByExample(@Param("record") BlogTagRelation record, @Param("example") BlogTagRelationExample example);

    int updateByPrimaryKeySelective(BlogTagRelation record);

    int updateByPrimaryKey(BlogTagRelation record);
    @Slave
    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelationList);

    @Master
    int batchDelete(Integer[] blogIds);

    List<Long> selectDistinctTagIds(Integer[] tagIds);
}