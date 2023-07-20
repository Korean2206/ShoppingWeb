package com.korea.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.korea.dao.UserDAO;
import com.korea.entity.User;
import com.korea.service.CookieService;
import com.korea.service.ParamService;
import com.korea.service.SessionService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    ParamService param;

    @Autowired
    CookieService cookieService;

    @Autowired
    SessionService sessionService;

    @Autowired
    UserDAO dao;
    @GetMapping("login")
    public String login(){
        return "user/account/login";

    }

    @PostMapping("login")
    public String login(Model model){
       String username = param.getString("username","");
       String password = param.getString("password","");
       Boolean rememberMe = param.getBoolean("remember", false);
       User user = dao.findbyUsername(username);
       String error = "";
       if(user == null) {
       error = "Tài khoản không tồn tại";
       }else {
        if(user.getPassword().equals(password)){
            if(rememberMe){
                cookieService.add("username", username,1000);
            }else {
                cookieService.remove("username");
            }
            sessionService.set("username", username);
            return "user/index";
        }else {
            error ="Bạn nhập sai mật khẩu";

        }
       }
        return "user/account/login";
    }
    @GetMapping("register")
    public String register(Model model){
        User user = new User();
		model.addAttribute("user", user);
        return "user/account/register";
    }
    @PostMapping("register")
    public String register(User user){
       dao.save(user);
       System.out.println("success");
        return "forward:/user/login";
    }
    @GetMapping("profile")
    public String profile(Model model){
        String username = sessionService.get("username", "");
        User user =  dao.findById(username).get();
        model.addAttribute("infor", user);
        return "user/account/profile";
    }
    @PostMapping("profile")
    public String profile(Model model,@RequestParam("attach") MultipartFile file){
        String username = sessionService.get("username", "");
        String fullname = param.getString("fullname", "");
        String email = param.getString("email", "");
        String password = param.getString("password", "");
        String image = file.getOriginalFilename();
        param.save(file, "/avatar");
        User user =  dao.findById(username).get();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        if(image != "")
        user.setImage(image);
        dao.save(user);
        model.addAttribute("infor", user);

        return "user/account/profile";
    }
    @PostMapping("profile/cancel")
    public String cancel(Model model,@RequestParam("attach") MultipartFile file){
        return "redirect:/user/profile";
    }

    @RequestMapping("logout")
    public String logout(){
        sessionService.remove("username");
        cookieService.remove("username");
        return "redirect:/user/login";
    }
}
