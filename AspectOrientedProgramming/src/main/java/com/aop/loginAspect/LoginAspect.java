package com.aop.loginAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class LoginAspect {
    @Before("execution(public String addAccount(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Method argumets are :");
        Object[] args = joinPoint.getArgs();
        String longString = joinPoint.getSignature().toLongString();
        System.out.println(longString);
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
    @AfterReturning(value = "execution(public String addAccount(..))", returning = "returnValue")
    public void afterRemoveAccount(JoinPoint join,String returnValue) {
        System.out.println("This is after the execution of removeAccount order 1");
        System.out.println(returnValue);
    }



}
