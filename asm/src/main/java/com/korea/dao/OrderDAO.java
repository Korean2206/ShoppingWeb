package com.korea.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    
   
}
