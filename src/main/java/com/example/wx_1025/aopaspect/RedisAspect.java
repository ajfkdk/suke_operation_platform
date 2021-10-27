package com.example.wx_1025.aopaspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

/**
 * The type Redis aspect.
 *
 * @program: wx_1025
 * @description: 关于redis的aspect
 * @author: chenzou
 * @create: 2021 -10-27 14:22
 */
@Aspect
@Component
@Slf4j

public class RedisAspect {

    /**
     * Point cut.关于redisAnnotation的注解的切面
     */
    @Pointcut("@annotation(com.example.wx_1025.my_annotation.redisAnnotation)")
    public void pointCut() {}

    /**
     * After throwing.报错的处理切面
     *
     * @param joinPoint the join point
     * @param ex        the ex
     */
    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String specialError = "Unable to connect to Redis";
        String message = ex.getMessage();
        if (!specialError.contains(message)) {
            log.error("无法连接到redis的服务器");
        }
    }

    /**
     * Do before.前面之前的操作
     *
     * @param joinPoint the join point
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
//        // 获取签名
//        Signature signature = joinPoint.getSignature();
//        // 获取切入的包名
//        String declaringTypeName = signature.getDeclaringTypeName();
//        // 获取即将执行的方法名
//        String funcName = signature.getName();
//        log.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);  即将执行方法为: getToken，属于com.example.wx_1025.util.TokenUtil包

    }

}
