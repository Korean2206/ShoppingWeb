package com.korea.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.dao.CartDAO;
import com.korea.dao.CartItemDAO;
import com.korea.dao.ProductDAO;
import com.korea.dao.UserDAO;
import com.korea.entity.Cart;
import com.korea.entity.CartItem;
import com.korea.entity.Product;

@Service
public class CartImplement implements CartService {

    Map<Integer, CartItem> cart = new HashMap<>();

    @Autowired
    ProductDAO dao;
    @Autowired
    CartDAO daoC;

    @Autowired
    SessionService sessionService;

    @Autowired
    CartItemDAO daoI;
    @Override
    public void addCart(List<CartItem> items) {
        for (int i = 0; i < items.size(); i++) {
            cart.put(items.get(i).getProduct().getId(), items.get(i));
        }
    }

    @Override
    public CartItem add(Integer id) {
        Cart cartID = daoC.findByUser(sessionService.get("username", null));
        CartItem item = cart.get(id);
        if (item == null) {
            Product p = dao.findByID(id);
            item = new CartItem();
            item.setProduct(p);
            item.setCart(cartID);
            cart.put(id, item);

        } else {
            item.setId(item.getId());
            item.setQuantity(item.getQuantity() + 1);
        }
        daoI.save(item);
        return item;
    }

    @Override
    public void remove(Integer id) {
        // TODO Auto-generated method stub
        daoI.delete(cart.get(id));
        cart.remove(id);
        
    }

    @Override
    public CartItem update(Integer id, int qty) {
        // TODO Auto-generated method stub
        CartItem item = cart.get(id);
        item.setQuantity(qty);
        daoI.save(item);

        return item;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        cart.clear();
    }

    @Override
    public Collection<CartItem> getItems() {
        // TODO Auto-generated method stub
        return cart.values();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cart.values().stream().mapToInt(item -> item.getQuantity()).sum();
    }

    @Override
    public double getAmount() {
        // TODO Auto-generated method stub
        return cart.values().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }

}
