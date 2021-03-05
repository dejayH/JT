package com.jt.aop;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SysResultException {

    @ExceptionHandler({RuntimeException.class})
    public SysResult exception(Exception e){
        e.printStackTrace();
        return SysResult.fail();
    }
}
