package com.jt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.framework.Advised;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RedisAOP {

    //1.定义切入点表达式
    @Pointcut("bean(itemCatServiceImpl)")
    public void piontCut(){

    }

    @Before("piontCut()")
    public void before(JoinPoint joinPoint){



    }

}
