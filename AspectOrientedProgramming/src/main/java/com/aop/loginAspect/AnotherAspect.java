package com.aop.loginAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class AnotherAspect {
    @Pointcut("execution(public void addAccount())")
    public void addAccount(){}

    @Pointcut("execution(public void deleteAccount())")
    public void deleteDao(){}


    @Around("deleteDao()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around delete of order 2");
        System.out.println("the execution time of the dlelete method is");
        long now = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("total time of the dlelete method is " + end+ "\n\n\n");


    }



}
