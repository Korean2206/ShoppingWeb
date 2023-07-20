package com.korea.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.korea.dao.CartDAO;
import com.korea.dao.CartItemDAO;
import com.korea.dao.UserDAO;
import com.korea.entity.Cart;
import com.korea.entity.CartItem;
import com.korea.service.CartService;
import com.korea.service.SessionService;

@Service
public class CartInterceptor implements HandlerInterceptor {

    @Autowired
    CartService cart;

    @Autowired
    CartDAO daoC;
    @Autowired
    UserDAO daoU;
    @Autowired
    SessionService sessionService;
    @Autowired
    CartItemDAO daoI;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String uri = request.getRequestURI();

        if (sessionService.get("username", null) != null) {
            Cart cart1 = daoC.findByUser(sessionService.get("username", null));
            if (cart1 == null) {
                cart1 = new Cart();
                cart1.setUser(daoU.findbyUsername(sessionService.get("username", null)));
                daoC.save(cart1);
            } else {
                List<CartItem> items = daoI.findByUsername(sessionService.get("username", null));
                cart.addCart(items);
                request.setAttribute("cart", cart);
                request.setAttribute("count", cart.getCount());
            }
            if(uri.contains("/cart/pay")){
                if(cart.getCount() == 0){
                    response.sendRedirect("/home/index?error="+URLEncoder.encode("Giỏ_Hàng_Trống", "UTF-8"));
                    return false;
                }
            }
        } else {
            request.setAttribute("count", 0);
            if (uri.contains("/cart/")) {
                response.sendRedirect("/user/login");

                return false;
            }

        }

        return true;
    }

}
