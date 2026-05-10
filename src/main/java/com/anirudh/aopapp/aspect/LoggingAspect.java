package com.anirudh.aopapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    @Before("execution(* com.anirudh.aopapp.service.impl.ShipmentServiceImpl.*(..))")
//    public void beforeShipmentServiceMethod(JoinPoint joinPoint){
//        log.info("Before method call: {}", joinPoint.getSignature());
//    }

//    @Before("execution(* orderPackage(..))")
    @Before("execution(* com.anirudh.aopapp.service.impl.ShipmentServiceImpl.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before method kind: {}", joinPoint.getKind());
        log.info("Before method call: {}", joinPoint.getSignature());
    }

    // @Before("within(com.anirudh.aopapp..*)")
    @Before("within(com.anirudh.aopapp.service.impl.*)")
    public void beforeServiceImplCalls(){
        log.info("Service Impl Calls");
    }

    @After("myLoggingAopMethodsPointCut()")
    public void afterServiceImplCalls(){
        log.info("After Service Impl Calls");
    }

    @Before("myLoggingAopMethodsPointCut()")
    public void logTransactionalLog(){
        log.info("Before transactional annotation calls");
    }

    @Pointcut("@annotation(com.anirudh.aopapp.aspect.MyLoggingAnnotation) && within(com.anirudh.aopapp.service.impl.*)" )
    public void myLoggingAopMethodsPointCut() {

    }


}