package com.korea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer> {
    
    @Query("SELECT o FROM Cart o WHERE o.user.username Like ?1")
    Cart findByUser(String username);
}
