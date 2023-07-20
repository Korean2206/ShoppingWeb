package com.korea.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.dao.ProductDAO;
import com.korea.entity.Product;

@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    ProductDAO dao;

    
    @RequestMapping("index")
    public String index(Model model){
        List<Product> items = dao.finByBestSeller();
        model.addAttribute("items", items);
        model.addAttribute("view", "home/index");
        return "user/index";
    }

    
}
