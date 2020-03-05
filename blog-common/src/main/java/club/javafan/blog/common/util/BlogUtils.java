package club.javafan.blog.common.util;

import java.net.URI;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/28 20:52
 * @desc 博客工具类
 */
public class BlogUtils {

    /**
     * 获取URI
     *
     * @param uri
     * @return
     * @throws Exception
     */
    public static URI getHost(URI uri) throws Exception {
        URI effectiveURI = new URI(uri.getScheme(), uri.getUserInfo()
                , uri.getHost(), uri.getPort(), null, null, null);
        return effectiveURI;
    }

}