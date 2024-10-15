package com.tedu.teamserver.exception;



import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class gpExceptionHandler {

    @ExceptionHandler
    public ServerResult exceptionHanlde(Throwable e){
        String message = e.getMessage();
        e.printStackTrace();

        ServerResult serverResult = new ServerResult(500, "server ERROR!", message);
        return serverResult;
    }
}
