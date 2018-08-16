package com.study.server.interceptor;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestInterceptor {
    @Before("execution(* com.study.server.controller.UserController.delete(..))")
    public void before() {
        System.out.println("前置通知....");
    }

}
