package com.korea.controller.user;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.korea.dao.CartDAO;
import com.korea.dao.CartItemDAO;
import com.korea.dao.OrderDAO;
import com.korea.dao.OrderDetailDAO;
import com.korea.dao.ProductDAO;
import com.korea.dao.UserDAO;
import com.korea.entity.Cart;
import com.korea.entity.CartItem;
import com.korea.entity.Order;
import com.korea.entity.OrderDetail;
import com.korea.entity.User;
import com.korea.service.CartService;
import com.korea.service.ParamService;
import com.korea.service.SessionService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    ProductDAO dao;

    @Autowired
    CartService cart;

    @Autowired
    ParamService param;

    @Autowired
    SessionService sessionService;

    @GetMapping("index")
    public String index(Model model) {

        model.addAttribute("amount", cart.getAmount());
        return "user/cart";
    }

    @RequestMapping("add")
    public String addProduct(Model model, @RequestParam("id") Optional<Integer> id,
            @RequestParam("index") Optional<String> index) {
        cart.add(id.get());
        String uri = index.get();
       
        return "forward:/" + uri;
    }

    @RequestMapping("update")
    public String update() {
        Integer id = param.getInt("id", 0);
        int qty = param.getInt("qty", 0);
        if(qty <= 0)
        cart.remove(id);
        else
        cart.update(id, qty);
        
        return "redirect:/cart/index";
    }

    @RequestMapping("remove")
    public String remove(@RequestParam("id") Integer id, @RequestParam("index") Optional<String> index) {
        cart.remove(id);
        String uri = index.get();
        if(uri.equals("cart"))
        return "redirect:/cart/index";
        if(!uri.startsWith("home") )
            uri = "product/" + uri;
        
        return "forward:/" + uri;
    }

    @Autowired
    CartDAO daoC;

    @Autowired
    CartItemDAO daoI;

    @Autowired
    OrderDAO daoOd;

    @Autowired
    UserDAO daoU;
    
    @Autowired
    OrderDetailDAO daoDt;

    @RequestMapping("pay")
    public String pay(){
        String username = sessionService.get("username", null);
        Cart cartId = daoC.findByUser(username);
        User user = daoU.findbyUsername(username);
        List<CartItem> items = daoI.findByUsername(username);
        Order order = new Order();
        order.setUser(user);
        order.setAddress(user.getAddress());
        daoOd.save(order);
        for(CartItem item : items){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(item.getProduct());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setPrice(item.getProduct().getPrice() * item.getQuantity());
            daoDt.save(orderDetail);
        }
        daoI.deleteByCartID(cartId.getId());
        cart.clear();
        return "redirect:/home/index";
    }
    
}
