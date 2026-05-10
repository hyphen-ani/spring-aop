package com.anirudh.aopapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ValidationAspect {

    @Around("allServiceMethodPointCut()")
    public Object validateArgs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object args[] = proceedingJoinPoint.getArgs();
        Long orderId = (Long)args[0];

        if(orderId > 0) return proceedingJoinPoint.proceed();

        return "Cannot call with negative orderId";


    }


    @Pointcut("execution(* com.anirudh.aopapp.service.impl.*.*(..))")
    public void allServiceMethodPointCut(){}

}
