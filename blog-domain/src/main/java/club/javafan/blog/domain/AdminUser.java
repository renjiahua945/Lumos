package club.javafan.blog.domain;

import lombok.Data;

@Data
public class AdminUser {
    /**
    * 管理员id
    */
    private Integer adminUserId;

    /**
     * 管理员登录名称
    */
    private String loginUserName;

    /**
     * 管理员登录密码
    */
    private String loginPassword;

    /**
    * 管理员显示昵称
    */
    private String nickName;

    /**
     * 是否锁定 0未锁定 1已锁定无法登录
    */
    private Byte locked;
}