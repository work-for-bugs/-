package com.tedu.teamserver.exception;

import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TeamExceptionHandler {
    @ExceptionHandler
    public ServerResult exceptionHandler(Throwable e){
        String message = e.getMessage();
        e.printStackTrace();
        ServerResult serverResult = new ServerResult(500, "服务器出错，到控制台查看错误信息", message);
        return serverResult;
    }

}
