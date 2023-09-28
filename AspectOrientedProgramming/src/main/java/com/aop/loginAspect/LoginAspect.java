package com.aop.loginAspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    @Before("execution(public void addAccount())")
    public void beforeAddAccount(){
        System.out.println("This is before the execution of addAccount");
    }
}
