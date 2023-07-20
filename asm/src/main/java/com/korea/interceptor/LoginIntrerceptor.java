package com.korea.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.korea.dao.UserDAO;
import com.korea.entity.User;
import com.korea.service.CookieService;
import com.korea.service.SessionService;

@Service
public class LoginIntrerceptor implements HandlerInterceptor {
    @Autowired
    CookieService cookieService;

    @Autowired
    UserDAO dao;

    @Autowired
    SessionService sessionService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String username = cookieService.getValue("username", sessionService.get("username", null));
        User user = dao.findbyUsername(username);
        if (user != null) {
            sessionService.set("username", username);
            response.sendRedirect("/home/index");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
            throws Exception {
        String username = cookieService.getValue("username", sessionService.get("username", null));
        User user = dao.findbyUsername(username);
        if (user != null) {
            sessionService.set("username", username);
            response.sendRedirect("/home/index");
        }
    }
}
