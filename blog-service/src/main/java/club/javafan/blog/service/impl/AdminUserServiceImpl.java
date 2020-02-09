package club.javafan.blog.service.impl;


import club.javafan.blog.common.Result.ResponseResult;
import club.javafan.blog.common.util.MD5Util;
import club.javafan.blog.domain.AdminUser;
import club.javafan.blog.domain.example.AdminUserExample;
import club.javafan.blog.repository.AdminUserMapper;
import club.javafan.blog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/11 22:12
 * @desc 管理员登录服务类
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.md5Encode(password, "UTF-8");
        System.out.println(passwordMd5);
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().
                andLoginUserNameEqualTo(userName).
                andLoginPasswordEqualTo(passwordMd5);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminUsers)) {
            return null;
        }
        return adminUsers.get(INTEGER_ZERO);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public AdminUser getUserDetailByUserName(String loginName) {
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andLoginUserNameEqualTo(loginName);
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminUsers)) {
            return null;
        }
        return adminUsers.get(INTEGER_ZERO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (Objects.nonNull(adminUser)) {
            String originalPasswordMd5 = MD5Util.md5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.md5Encode(newPassword, "UTF-8");
            String loginPassword = adminUser.getLoginPassword();
            //比较原密码是否正确
            if (originalPasswordMd5.equals(loginPassword)) {
                //原密码和新设置的密码相同返回false
                if (loginPassword.equals(newPasswordMd5)) {
                    return ResponseResult.failResult("新密码不能和原密码相同！");
                }
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                int count = adminUserMapper.updateByPrimaryKeySelective(adminUser);
                if (count > INTEGER_ZERO) {
                    //修改成功则返回true
                    return ResponseResult.successResult("修改成功！");
                }
            }
            return ResponseResult.failResult("原密码不正确！");
        }
        return ResponseResult.failResult("失败！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (Objects.nonNull(adminUser)) {
            //设置新密码并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            int count = adminUserMapper.updateByPrimaryKeySelective(adminUser);
            if (count > INTEGER_ZERO) {
                //修改成功则返回true
                return ResponseResult.successResult("成功！");
            }
        }
        return ResponseResult.failResult("修改失败！");
    }
}
