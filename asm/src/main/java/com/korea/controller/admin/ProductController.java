package com.korea.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.korea.dao.CategoryDAO;
import com.korea.dao.ProductDAO;
import com.korea.entity.Category;
import com.korea.entity.Product;
import com.korea.service.ParamService;
import com.korea.service.SessionService;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    ProductDAO dao;
    @Autowired
    CategoryDAO category;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @Autowired
    HttpServletRequest request;

    public List<Category> getCategories() {
        return category.findByGender(paramService.getBoolean("gender", true));
    }

    @GetMapping("list")
    public String product(Model model) {
        List<Product> list = dao.findAll();
        model.addAttribute("items", list);
        model.addAttribute("view", "manage/qlsp.jsp");
        return "admin/dashboard";
    }

    @GetMapping("create")
    public String create(Model model) {

        model.addAttribute("uri", "create");
        model.addAttribute("categories", getCategories());
        model.addAttribute("view", "manage/product.jsp");
        model.addAttribute("ad", sessionService.get("ad", ""));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @RequestMapping("cancel")
    public String cancel(Model model) {

        return "redirect:/admin/product/create";

    }

    @PostMapping("create")
    public String create(@RequestParam("attach") MultipartFile file, Model model) {
        try {

            Category cid = category.findByGenderAndName(paramService.getBoolean("gender", false),
                    paramService.getString("loai", ""));
            Product item = new Product();
            item.setName(paramService.getString("name", null));
            item.setPrice(paramService.getDouble("price", 0.0));
            item.setQuantity(paramService.getInt("quantity", 1));
            item.setDescription(paramService.getString("description", null));
            String image = file.getOriginalFilename();
            paramService.save(file, "/product");
            if (image != "")
                item.setImage(image);
            item.setCategory(cid);
            dao.save(item);
            sessionService.set("ad", "Thêm thành công");
        } catch (Exception e) {
            sessionService.set("ad", "Thêm thất bại");

        }
        return "redirect:/admin/product/create";
    }

    @RequestMapping("delete")
    public String delete(Model model) {
        Product item = dao.findByID(paramService.getInt("id", -1));
        dao.delete(item);
        return "redirect:/admin/product/list";
    }

    @GetMapping("update")
    public String update(Model model) {

        Product item = dao.findByID(paramService.getInt("id", -1));

        model.addAttribute("uri", "update");
        model.addAttribute("categories", getCategories());
        model.addAttribute("view", "manage/product.jsp");
        model.addAttribute("item", item);
        model.addAttribute("ad",sessionService.get("ad", null));
        sessionService.remove("ad");
        return "admin/dashboard";
    }

    @PostMapping("update")
    public String update(@RequestParam("attach") MultipartFile file) {
        try {
        Category cid = category.findByGenderAndName(paramService.getBoolean("gender", false),
                    paramService.getString("loai", ""));
        System.out.println("id: "+paramService.getInt("id", 0));
        Product item = dao.findByID(paramService.getInt("id", -1));
        item.setName(paramService.getString("name", null));
        item.setPrice(paramService.getDouble("price", 0.0));
        item.setQuantity(paramService.getInt("quantity", 1));
        item.setDescription(paramService.getString("description", null));
        String image = file.getOriginalFilename();
        paramService.save(file, "/product");
        if (image != "")
            item.setImage(image);
        item.setCategory(cid);
        dao.save(item);
        sessionService.set("ad", "Update thành công");
        } catch (Exception e) {
        sessionService.set("ad", "Update thất bại");
        }

        return "redirect:/admin/product/update";
    }
}
