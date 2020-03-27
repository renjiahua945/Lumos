package club.javafan.blog.web.filter;

import club.javafan.blog.common.constant.RedisKeyConstant;
import club.javafan.blog.common.util.CookiesUtil;
import club.javafan.blog.common.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static club.javafan.blog.common.constant.CommonConstant.COOKIES;
import static club.javafan.blog.common.constant.CommonConstant.LOGIN_USER_NAME;
import static java.util.Objects.isNull;


@Component
public class
AdminLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        if (!uri.startsWith("/admin")) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        Cookie useCookies = CookiesUtil.getCookie(LOGIN_USER_NAME, request.getCookies());
        if (isNull(useCookies) || isNull(useCookies.getValue())) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }
        Cookie cookie = CookiesUtil.getCookie(COOKIES, request.getCookies());
        String sessionId = (String) redisUtil.get(RedisKeyConstant.BLOG_SESSION + useCookies.getValue());
        if (isNull(cookie) || StringUtils.isEmpty(sessionId) || !sessionId.equals(cookie.getValue())) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}