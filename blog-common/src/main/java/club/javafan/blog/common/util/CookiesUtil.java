package club.javafan.blog.common.util;

import javax.servlet.http.Cookie;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * cookies 的相关操作
 *
 * @author 不会敲代码的小白
 * @date 2020/2/8
 */

public class CookiesUtil {
    /**
     * 获取指定key的cookies
     *
     * @param key
     * @param cookies
     * @return
     */
    public static Cookie getCookie(String key, Cookie[] cookies) {
        Optional<Cookie> optional = Stream.of(cookies).filter(cookie -> key.equals(cookie.getName())).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }

}
