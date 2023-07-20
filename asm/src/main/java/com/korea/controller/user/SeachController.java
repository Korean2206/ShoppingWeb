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
import com.korea.service.SessionService;

@Controller
public class SeachController {
    
    @Autowired
    SessionService sessions;

    @Autowired
    ProductDAO dao;

    public Page sort(String name,String sort, Optional<Integer> p) {
        Page<Product> page;
        Pageable pageable;
        switch (sort) {
            case "A":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name"));
                page = dao.findByKeyword("%"+name+"%", pageable);
                break;
            case "Z":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("name").descending());

                page = dao.findByKeyword("%"+name+"%", pageable);
                break;
            case "N":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("id").descending());

                page = dao.findByKeyword("%"+name+"%", pageable);
                break;
            case "T":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price"));

                page = dao.findByKeyword("%"+name+"%", pageable);
                break;
            case "C":
                pageable = PageRequest.of(p.orElse(0), 12, Sort.by("price").descending());

                page = dao.findByKeyword("%"+name+"%", pageable);
                break;

            default:
                pageable = PageRequest.of(p.orElse(0), 12);
                page = dao.findByKeyword("%"+name+"%", pageable);
                break;
        }
        return page;
    }

    @RequestMapping("/product/search")
    public String search(Model model,@RequestParam("keyword") Optional<String> keyword,@RequestParam("p") Optional<Integer> p,
    @RequestParam("sort") Optional<String> option) {
        String kw = keyword.orElse(sessions.get("name", ""));
        sessions.set("name", kw);
        Page<Product> page = sort(kw,option.orElse(""),p);
        model.addAttribute("page", page);
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= page.getTotalPages(); i++) {
            number.add(i);
        }
        model.addAttribute("number", number);
        model.addAttribute("view","search");
        return "forward:/product";

    }
}
