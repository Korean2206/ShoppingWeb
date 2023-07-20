package com.korea.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.korea.dao.UserDAO;
import com.korea.entity.Category;
import com.korea.entity.Product;
import com.korea.entity.User;
import com.korea.service.ParamService;
import com.korea.service.SessionService;

@Controller
@RequestMapping("admin/account")
public class AccountController {

    @Autowired
    UserDAO dao;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("employee")
    public String employee(Model model) {
        List<User> list = dao.findByAdmin(true);
        model.addAttribute("items", list);
        model.addAttribute("view", "manage/qlnv.jsp");
        return "admin/dashboard";
    }

    @GetMapping("employee/create")
    public String eCreate(Model model) {
        List<User> list = dao.findByAdmin(true);
        model.addAttribute("items", list);
        model.addAttribute("uri", "employee");
        model.addAttribute("action", "create");
        model.addAttribute("view", "manage/user.jsp");
        model.addAttribute("ad", sessionService.get("ad", ""));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @PostMapping("employee/create")
    public String eCreate(@RequestParam("attach") MultipartFile file) {
        try {
            User user = new User();
            user.setFullname(paramService.getString("fullname", null));
            user.setUsername(paramService.getString("username", null));
            user.setPassword(paramService.getString("password", null));
            user.setEmail(paramService.getString("email", null));
            user.setAddress(paramService.getString("address", null));
            user.setMobile(paramService.getString("mobile", null));
            user.setGender(paramService.getBoolean("gender", false));
            user.setAdmin(true);
            String image = file.getOriginalFilename();
            paramService.save(file, "/avatar");
            if (image != "")
                user.setImage(image);
            dao.save(user);
            sessionService.set("ad", "Thêm thành công");
        } catch (Exception e) {
            sessionService.set("ad", "Thêm thất bại");

        }
        return "redirect:/admin/account/employee/create";
    }

    @GetMapping("employee/update")
    public String eUpdate(Model model) {
        User user = dao.findbyUsername(paramService.getString("id", null));

        model.addAttribute("user", user);
        model.addAttribute("uri", "employee");
        model.addAttribute("action", "update");
        model.addAttribute("view", "manage/user.jsp");
        model.addAttribute("ad", sessionService.get("ad", ""));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @RequestMapping("employee/delete")
    public String delete() {
        User user = dao.findbyUsername(paramService.getString("id", null));
        dao.delete(user);
        return "redirect:/admin/account/employee";
    }
    @PostMapping("employee/update/cancel")
    public String eUCancel() {
        return "redirect:/admin/account/employee/update";
    }
    @PostMapping("employee/create/cancel")
    public String eCCancel() {
        return "redirect:/admin/account/employee/create";
    }

    @PostMapping("employee/update")
    public String eUpdate(@RequestParam("attach") MultipartFile file) {
        try {
            User user = dao.findbyUsername(paramService.getString("username", null));
            user.setFullname(paramService.getString("fullname", null));
            user.setUsername(paramService.getString("username", null));
            user.setPassword(paramService.getString("password", null));
            user.setEmail(paramService.getString("email", null));
            user.setAddress(paramService.getString("address", null));
            user.setMobile(paramService.getString("mobile", null));
            user.setGender(paramService.getBoolean("gender", false));
            user.setAdmin(true);
            String image = file.getOriginalFilename();
            paramService.save(file, "/avatar");
            if (image != ""){
                user.setImage(image);
            }
            dao.save(user);
            sessionService.set("ad", "Cập nhật thành công");
        } catch (Exception e) {

            sessionService.set("ad", "Cập nhật thất bại");

        }
        return "redirect:/admin/account/employee/update";
    }

    @GetMapping("customer")
    public String customer(Model model) {
        List<User> list = dao.findByAdmin(false);
        model.addAttribute("items", list);
        model.addAttribute("view", "manage/qlkh.jsp");
        return "admin/dashboard";
    }

     @GetMapping("customer/create")
    public String cCreate(Model model) {
        List<User> list = dao.findByAdmin(true);
        model.addAttribute("items", list);
        model.addAttribute("uri", "customer");
        model.addAttribute("action", "create");
        model.addAttribute("view", "manage/user.jsp");
        model.addAttribute("ad", sessionService.get("ad", ""));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @PostMapping("customer/create")
    public String cCreate(@RequestParam("attach") MultipartFile file) {
        try {
            User user = new User();
            user.setFullname(paramService.getString("fullname", null));
            user.setUsername(paramService.getString("username", null));
            user.setPassword(paramService.getString("password", null));
            user.setEmail(paramService.getString("email", null));
            user.setAddress(paramService.getString("address", null));
            user.setMobile(paramService.getString("mobile", null));
            user.setGender(paramService.getBoolean("gender", false));
            user.setAdmin(false);
            String image = file.getOriginalFilename();
            paramService.save(file, "/avatar");
            if (image != "")
                user.setImage(image);
            dao.save(user);
            sessionService.set("ad", "Thêm thành công");
        } catch (Exception e) {
            sessionService.set("ad", "Thêm thất bại");

        }
        return "redirect:/admin/account/customer/create";
    }

    @GetMapping("customer/update")
    public String cUpdate(Model model) {
        User user = dao.findbyUsername(paramService.getString("id", null));

        model.addAttribute("user", user);
        model.addAttribute("uri", "customer");
        model.addAttribute("action", "update");
        model.addAttribute("view", "manage/user.jsp");
        model.addAttribute("ad", sessionService.get("ad", ""));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @PostMapping("customer/update/cancel")
    public String cUCancel() {
        return "redirect:/admin/account/customer/update";
    }
    @PostMapping("customer/create/cancel")
    public String cCCancel() {
        return "redirect:/admin/account/customer/create";
    }

    @PostMapping("customer/update")
    public String cUpdate(@RequestParam("attach") MultipartFile file) {
        try {
            User user = dao.findbyUsername(paramService.getString("username", null));
            user.setFullname(paramService.getString("fullname", null));
            user.setPassword(paramService.getString("password", null));
            user.setEmail(paramService.getString("email", null));
            user.setAddress(paramService.getString("address", null));
            user.setMobile(paramService.getString("mobile", null));
            user.setGender(paramService.getBoolean("gender", false));
            user.setAdmin(false);
            String image = file.getOriginalFilename();
            paramService.save(file, "/avatar");
            if (image != ""){
                user.setImage(image);
            }
            dao.save(user);
            sessionService.set("ad", "Cập nhật thành công");
        } catch (Exception e) {
            System.out.println(paramService.getString("id", "null"));
            sessionService.set("ad", "Cập nhật thất bại");

        }
        return "redirect:/admin/account/customer/update";
    }
    @RequestMapping("customer/delete")
    public String cdelete() {
        User user = dao.findbyUsername(paramService.getString("id", null));
        dao.delete(user);
        return "redirect:/admin/account/customer";
    }
}
