package com.korea.service;


import java.util.Collection;
import java.util.List;

import com.korea.entity.CartItem;

public interface CartService {

    CartItem add(Integer id);

    void remove(Integer id);

    CartItem update(Integer id, int qty);

    void clear();

    Collection<CartItem> getItems();

    int getCount();

    double getAmount();
    void addCart(List<CartItem> items);
}
