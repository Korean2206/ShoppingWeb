package com.korea.controller.admin;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.dao.OrderDAO;
import com.korea.dao.OrderDetailDAO;
import com.korea.entity.Order;
import com.korea.entity.OrderDetail;
import com.korea.entity.User;
import com.korea.service.ParamService;

@Controller
@RequestMapping("admin/order")
public class OrderController {
    
    @Autowired
    OrderDAO dao;
    @Autowired
    ParamService paramService;
    @Autowired
    OrderDetailDAO orderDetailDAO;
    @GetMapping("list")
    public String order(Model model){
        List<Order> list = dao.findAll();
        model.addAttribute("items", list);
        model.addAttribute("view","manage/qldh.jsp");
        return "admin/dashboard";
    }

    @RequestMapping("delete")
    public String delete(){
       Optional<Order> order = dao.findById(paramService.getInt("id", -1));
        dao.delete(order.get());
        return "redirect:/admin/order/list";
    }

    @RequestMapping("order_detail")
    public String detail(Model model){
        List<OrderDetail> list = orderDetailDAO.finByOrderID(paramService.getInt("id", -1));
        model.addAttribute("items", list);
        model.addAttribute("view","manage/orderDetails.jsp");
        return "admin/dashboard";
    }
}
