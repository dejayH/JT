package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class SysResult {

    private Integer status;    //如果后端服务器运行正常 返回200 否则返回201 表示失败
    private String msg;        //服务器返回提示
    private Object data;       //服务器返回业务数据

    public static SysResult fail() {
        return new SysResult(201, "服务器请求异常,请稍后", null);
    }

    public static SysResult success() {
        return new SysResult(200, "服务器执行成功", null);
    }

    public static SysResult success(Object data) {
        return new SysResult(200, "服务器执行成功", data);
    }

    public static SysResult success(String msg,Object data) {
        return new SysResult(200, msg , data);
    }
}
