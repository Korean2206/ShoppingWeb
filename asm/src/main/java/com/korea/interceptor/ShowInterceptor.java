package com.korea.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.korea.dao.UserDAO;
import com.korea.service.CookieService;
import com.korea.service.SessionService;

@Service
public class ShowInterceptor implements HandlerInterceptor {

    @Autowired
    CookieService cookieService;

    @Autowired
    UserDAO dao;

    @Autowired
    SessionService sessionService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String username = cookieService.getValue("username", null);
        if(username != null) {
            sessionService.set("username", username);
        }

        return true;
    }
}
