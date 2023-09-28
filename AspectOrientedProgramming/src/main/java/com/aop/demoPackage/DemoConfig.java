package com.aop.demoPackage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.aop.Dao","com.aop.loginAspect"})

@EnableAspectJAutoProxy
public class DemoConfig {

}
