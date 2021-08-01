package com.tdw.khh2.common;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionAdvice {

    @ExceptionHandler(UsernameNotFoundException.class)
    public RestReply handleAuthenticationException(UsernameNotFoundException exception) {
        return RestReply.custom(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }


}
