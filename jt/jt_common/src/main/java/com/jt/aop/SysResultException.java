package com.jt.aop;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

//spring中的通知 核心原理:Spring AOP机制
@RestControllerAdvice  //只对Controller代码层级有效.
public class SysResultException {

    //当程序发生异常时, 如果没有try-catch则直接向上抛出异常.
    //该注解只拦截运行时异常.
    @ExceptionHandler({RuntimeException.class})
    public SysResult exception(Exception e){
        e.printStackTrace();
        return SysResult.fail();
    }
}
