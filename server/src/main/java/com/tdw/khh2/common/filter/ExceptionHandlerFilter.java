package com.tdw.khh2.common.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BadCredentialsException e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//            response.getWriter().write(convertObjectToJson(RestReply.custom(HttpStatus.NOT_FOUND.value(), e.getMessage())));
        } catch (AccessDeniedException e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        } catch (ExpiredJwtException e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        } catch (RuntimeException e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//            response.getWriter().write(convertObjectToJson(errorResponse));
        }

    }


    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
