package com.korea.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.CartItem;

public interface CartItemDAO extends JpaRepository<CartItem, Integer> {
   
    @Query(value="select o.* from cart_items o join carts i on i.id = o.cartID where i.userID Like ?1",nativeQuery = true)
    List<CartItem> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value="delete from cart_items where cartID = ?1",nativeQuery = true)
    void deleteByCartID(int cartID);

}
