package com.tdw.khh2.common.exception;

import com.tdw.khh2.common.RestReply;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log
@RestControllerAdvice
public class RestControllerExceptionAdvice {

    // jwt token 过期 401
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RestReply handleExpiredJwtException(ExpiredJwtException exception) {
        return RestReply.custom(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    // 未授权的访问，无jwt直接访问资源，entry point 401
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RestReply handleAuthenticationException(AuthenticationException exception) {
        return RestReply.custom(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }

    //验证失败或者用户名密码错误 404
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestReply handleBadCredentialsException(BadCredentialsException exception) {
        return RestReply.custom(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestReply handleException(Exception exception) {
        exception.printStackTrace();
        log.info("Exception:" + exception.getMessage());
        return RestReply.custom(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }
}
