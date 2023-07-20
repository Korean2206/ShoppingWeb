package com.korea.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
    
    @Query("SELECT o FROM OrderDetail o WHERE o.order.id = ?1")
    List<OrderDetail> finByOrderID(Integer orderID);
}
