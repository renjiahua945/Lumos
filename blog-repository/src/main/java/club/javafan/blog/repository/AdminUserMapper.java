package club.javafan.blog.repository;

import club.javafan.blog.domain.AdminUser;
import club.javafan.blog.domain.example.AdminUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {

    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Integer adminUserId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}