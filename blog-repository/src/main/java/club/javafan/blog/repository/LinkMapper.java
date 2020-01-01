package club.javafan.blog.repository;

import club.javafan.blog.common.annotation.Slave;
import club.javafan.blog.common.util.PageQueryUtil;
import club.javafan.blog.domain.BlogLink;
import club.javafan.blog.domain.example.LinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LinkMapper {
    long countByExample(LinkExample example);

    int deleteByExample(LinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    List<BlogLink> selectByExample(LinkExample example);

    BlogLink selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") BlogLink record, @Param("example") LinkExample example);

    int updateByExample(@Param("record") BlogLink record, @Param("example") LinkExample example);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);
    @Slave
    List<BlogLink> findLinkList(PageQueryUtil pageUtil);
    @Slave
    int getTotalLinks(PageQueryUtil pageUtil);
    @Slave
    int deleteBatch(Integer[] ids);

}