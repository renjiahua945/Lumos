package club.javafan.blog.domain.vo;

import lombok.Data;

/**
 * @author 敲代码的长腿毛欧巴
 * @date 2020/3/4
 */
@Data
public class QQUserInfoVO {
    /**
     *  QQ昵称
     */
    private String nickName;
    /**
     * QQ头像URL
     */
    private String headImage;
    /**
     * QQ号
     */
    private String qNumber;
    /**
     *  QQ邮箱
     */
    private String qEmail;
}
