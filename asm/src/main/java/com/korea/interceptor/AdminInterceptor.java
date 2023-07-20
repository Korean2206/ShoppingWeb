package com.korea.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.korea.dao.UserDAO;
import com.korea.entity.User;
import com.korea.service.SessionService;

@Service
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    SessionService sessionService;

    @Autowired
    UserDAO dao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();
        String adminID = sessionService.get("adminID", null);
        if (adminID == null) {
            if (!uri.contains("admin/login")){
                response.sendRedirect("/admin/login?error=notAdmin");
                return false;
            }
            else {
                return true;
            }
        } else {
            if (uri.contains("admin/login")) {
                response.sendRedirect("/admin/index?adminID=" + adminID);
                return false;
            }
        }
        User user = dao.findbyUsername(adminID);
        request.setAttribute("img", user.getImage());

        return true;
    }

}
