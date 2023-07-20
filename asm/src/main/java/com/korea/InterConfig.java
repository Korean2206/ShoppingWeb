package com.korea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.interceptor.AdminInterceptor;
import com.korea.interceptor.CartInterceptor;
import com.korea.interceptor.LoginIntrerceptor;
import com.korea.interceptor.ShowInterceptor;

@Configuration
public class InterConfig implements WebMvcConfigurer {
    
    @Autowired
    LoginIntrerceptor login;

    @Autowired
    ShowInterceptor show;

    @Autowired
    CartInterceptor cart;

    @Autowired
    AdminInterceptor admin;

    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(login)
        .addPathPatterns("/user/login");
    
        registry.addInterceptor(show)
        .addPathPatterns("/**");       

        registry.addInterceptor(cart)
        .addPathPatterns("/**");  
        registry.addInterceptor(admin)
        .addPathPatterns("/admin/**");
  }
}
