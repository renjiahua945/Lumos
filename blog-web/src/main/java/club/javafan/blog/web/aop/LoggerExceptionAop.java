package club.javafan.blog.web.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 不会敲代码的小白(博客)
 * @date 2019/12/10 22:57
 * @desc 日志处理和异常处理切面。主要作用打印入参和返回结果。
 * 也可以捕获异常。有条件的话可以吧捕获的异常做异常上报
 */
@Aspect
@Component
public class LoggerExceptionAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "execution(public * club.javafan.blog.service.impl.*.*(..))")
    private void servicePointCut() {
    }

    @Pointcut(value = "execution(public * club.javafan.blog.web.controller..*.*(..))")
    private void controllerPoint() {
    }

    @Before(value = "controllerPoint()||servicePointCut()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        StringBuilder log = new StringBuilder();
        log.append("club.javafan.blog: ")
                .append(className)
                .append("@")
                .append(methodName)
                .append(" , params: ");
        Object[] args = joinPoint.getArgs();
        //过滤掉request请求和response 避免异步请求出错
        List<Object> logArgs = Stream.of(args)
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        log.append(JSONObject.toJSONString(logArgs)).toString();
        logger.info(log.toString());
    }

    @AfterReturning(value = "controllerPoint()||servicePointCut()", returning = "returnObj")
    public void afterReturn(Object returnObj) {
        String result = JSONObject.toJSONString(returnObj);
        logger.info("club.javafan.blog return result: " + result);
    }

    @AfterThrowing(value = "controllerPoint()||servicePointCut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        logger.error("club.javafan.blog error : " + e.getMessage(), e);
    }

    @Around(value = "controllerPoint()||servicePointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Long begin = System.currentTimeMillis();
        StringBuilder log = new StringBuilder(className + "." + methodName + " :");
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        Long end = System.currentTimeMillis();
        log.append("执行时间: ")
                .append(end - begin)
                .append(" ms");
        logger.info(log.toString());
        return result;
    }


}