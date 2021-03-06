package com.qunar.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author YISHEN CAI
 */
@Aspect
@Component
public class RequestAspect {
    private final Logger logger = LoggerFactory.getLogger(RequestAspect.class);

    @Around("execution(* com.glancebar.mybatis.controller.*.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("request aspect init.....");
        long curr = System.currentTimeMillis();
        Object method = proceedingJoinPoint.proceed();
        for (Object arg : proceedingJoinPoint.getArgs()) {
            logger.info("arg:" + arg + ",");
        }
        long last = System.currentTimeMillis() - curr;
        logger.info("Request last: " + last + " milliseconds");
        // θΏεη»ζ
        return method;
    }
}
