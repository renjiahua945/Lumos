package club.javafan.blog.service;


import club.javafan.blog.common.result.ResponseResult;
import club.javafan.blog.domain.AdminUser;

public interface AdminUserService {

    AdminUser login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param loginUserId
     * @return
     */
    AdminUser getUserDetailById(Integer loginUserId);

    /**
     * 根据登录用户名获取用户信息
     *
     * @param loginName
     * @return
     */
    AdminUser getUserDetailByUserName(String loginName);

    /**
     * 修改当前登录用户的密码
     *
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    ResponseResult updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param loginUserId
     * @param loginUserName
     * @param nickName
     * @return
     */
    ResponseResult updateName(Integer loginUserId, String loginUserName, String nickName);

}
