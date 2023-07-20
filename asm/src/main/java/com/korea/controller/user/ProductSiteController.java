package com.korea.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.korea.dao.ProductDAO;
import com.korea.entity.Product;

@Controller
@RequestMapping("product")
public class ProductSiteController {

    @Autowired
    ProductDAO dao;

    @RequestMapping()
    public String index() {
        return "user/product/index";
    }

    public Page sort(boolean gender, String sort, Optional<Integer> p) {
        Page<Product> page;
        Pageable pageable;
        switch (sort) {
            case "A":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name"));
                page = dao.findByGender(gender, pageable);
                break;
            case "Z":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name").descending());

                page = dao.findByGender(gender, pageable);
                break;
            case "N":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("id").descending());

                page = dao.findByGender(gender, pageable);
                break;
            case "T":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price"));

                page = dao.findByGender(gender, pageable);
                break;
            case "C":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price").descending());

                page = dao.findByGender(gender, pageable);
                break;

            default:
                pageable = PageRequest.of(p.orElse(0), 12);
                page = dao.findByGender(gender, pageable);
                break;
        }
        return page;
    }

    public Page sort(boolean gender, String sort, Optional<Integer> p, String catagory1, String catagory2) {
        Page<Product> page;
        Pageable pageable;
        switch (sort) {
            case "A":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name"));
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
            case "Z":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name").descending());
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
            case "N":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("id").descending());
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
            case "T":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price"));
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
            case "C":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price").descending());
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
            default:
                pageable = PageRequest.of(p.orElse(0), 12);
                page = dao.findByGenderAndCategory(gender, catagory1, catagory2, pageable);
                break;
        }
        return page;
    }

   
    @RequestMapping("men")
    public String men(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p);
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        return "forward:/product/";
    }

    @RequestMapping("men/ao-thun")
    public String menTShirt(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Áo thun", "Áo thun");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/ao-thun");
        return "forward:/product/";
    }

    @RequestMapping("men/Ao-Khoac$Blazer")
    public String menaJacket(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Áo khoác", "Áo khoác");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/Ao-Khoac$Blazer");
        return "forward:/product/";

    }

    @RequestMapping("men/Quan")
    public String menPants(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Quần", "Quần");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/Quan");
        return "forward:/product/";

    }

    @RequestMapping("men/Tui&vi")
    public String menWB(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Túi", "Ví");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/Tui&vi");
        return "forward:/product/";

    }

    @RequestMapping("men/giay")
    public String menShoes(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Giày", "Giày");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/giay");
        return "forward:/product/";

    }

    @RequestMapping("men/Hoodies&Sweatshirt")
    public String menHS(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Hoodies", "Sweatshirt");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/Hoodies&Sweatshirt");
        return "forward:/product/";

    }

    @RequestMapping("men/phu-kien")
    public String menAccessories(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(true, option.orElse(""), p, "Phụ kiện", "Phụ kiện");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "men");
        model.addAttribute("view1", "/phu-kien");
        return "forward:/product/";

    }

    @RequestMapping("women")
    public String women(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p);

        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        return "forward:/product/";
    }

    @RequestMapping("women/ao-thun")
    public String womenTShirt(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Áo thun", "Áo thun");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/ao-thun");
        return "forward:/product/";
    }

    @RequestMapping("women/Ao-Khoac$Blazer")
    public String womenaJacket(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Áo khoác", "Áo khoác");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/Ao-Khoac$Blazer");
        return "forward:/product/";
    }

    @RequestMapping("women/Quan")
    public String womenPants(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Quần", "Quần");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/Quan");
        return "forward:/product/";
    }

    @RequestMapping("women/Tui&vi")
    public String womenWB(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Túi", "Ví");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/Tui&vi");
        return "forward:/product/";
    }

    @RequestMapping("women/giay")
    public String womenShoes(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Giày", "Giày");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/giay");
        return "forward:/product/";
    }

    @RequestMapping("women/Hoodies&Sweatshirt")
    public String womenHS(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Hoodies", "Sweatshirt");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/Hoodies&Sweatshirt");
        return "forward:/product/";
    }

    @RequestMapping("women/phu-kien")
    public String womenAccessories(Model model, @RequestParam("p") Optional<Integer> p,
            @RequestParam("sort") Optional<String> option) {
        Page<Product> page = sort(false, option.orElse(""), p, "Phụ kiện", "Phụ kiện");
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view", "women");
        model.addAttribute("view1", "/phu-kien");
        return "forward:/product/";
    }
    // @RequestMapping("best_seller")
    // public String bestSeller(Model model, @RequestParam("p") Optional<Integer>
    // p){
    // Pageable pageable = PageRequest.of(p.orElse(0), 12);
    // Page<Product> page = dao.findByGender(true,pageable);
    // model.addAttribute("page", page);
    // List<Integer> number = new ArrayList<Integer>();
    // for(int i = 1; i <= page.getTotalPages();i++){
    // number.add(i);
    // }
    // model.addAttribute("number", number);
    // model.addAttribute("view","best_seller");
    // return "forward:/product/";
    // }
}
