package com.korea.controller.admin;

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
import com.korea.service.ParamService;
import com.korea.service.SessionService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ParamService paramService;
    @Autowired
    UserDAO dao;

    @Autowired
    SessionService sessionService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("view", "index.jsp");
        return "admin/dashboard";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("login")
    public String loginPost(Model model) {
        String username = paramService.getString("username", null);
        String password = paramService.getString("password", null);
        User user = dao.findbyUsername(username);
        if (user != null) {
           
            System.out.println(user.getPassword());
            if (user.getPassword().equals(password)) {
                if (user.isAdmin()) {
                    sessionService.set("adminID", username);
                    return "redirect:/admin/index";
                } else {
                    model.addAttribute("message", "Bạn không phải admin");
                    return "admin/login";

                }
            } else {
                model.addAttribute("message", "Sai mật khẩu");
                return "admin/login";

            }
        } else {
            model.addAttribute("message", "Tài khoản không tồn tại");
            return "admin/login";
        }
    }

    @PostMapping("log_out")
    public String logOut() {
        sessionService.remove("adminID");
        return "redirect:/admin/login";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        String username = sessionService.get("adminID",null);
        User user = dao.findbyUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("view", "profile.jsp");
        return "admin/dashboard";
    }
    @PostMapping("profile")
    public String profile(Model model,@RequestParam("attach") MultipartFile file){
        String username = sessionService.get("adminID", "");
        String fullname = paramService.getString("fullname", "");
        String email = paramService.getString("email", "");
        String password = paramService.getString("password", "");
        String image = file.getOriginalFilename();
        paramService.save(file, "/avatar");
        User user =  dao.findById(username).get();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        if(image != "")
        user.setImage(image);
        dao.save(user);
        model.addAttribute("user", user);
        model.addAttribute("view", "profile.jsp");

        return "admin/dashboard";
    }

    @PostMapping("profile/cancel")
    public String cancel(Model model,@RequestParam("attach") MultipartFile file){
        return "redirect:/admin/profile";
    }

}
