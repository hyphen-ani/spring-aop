package com.anirudh.aopapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspectV2 {

    @Before("allServiceMethodPointCut()")
    public void beforeServiceMethodCall(JoinPoint joinPoint){
        log.info("Before Advice Method Call {}, {}", joinPoint.getSignature());
    }

//    @After("allServiceMethodPointCut()")
    @AfterReturning(value = "allServiceMethodPointCut()", returning = "returnObj")
    public void afterServiceMethodCall(JoinPoint joinPoint, Object returnObj){
        log.info("After Returning Advice Method Call {}, {}", joinPoint.getSignature(), returnObj);
    }

    @AfterThrowing("allServiceMethodPointCut()")
    public void afterThrowingAdvice(JoinPoint joinPoint){
        log.info("After throwing Advice Method Call {}", joinPoint.getSignature());
    }

    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();

        Long endTime = System.currentTimeMillis();
        Long diff = endTime - startTime;

        log.info("Time Taken for {} is {}ms", proceedingJoinPoint.getSignature(), diff);
        return returnedValue;
    }

    @Pointcut("execution(* com.anirudh.aopapp.service.impl.*.*(..))")
    public void allServiceMethodPointCut(){}

}
