package com.korea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.User;
import java.util.List;


public interface UserDAO extends JpaRepository<User, String> {
    
    @Query("SELECT o FROM User o WHERE o.admin = ?1")
    List<User> findByAdmin(boolean admin);

    @Query("SELECT o FROM User o WHERE o.username Like ?1 ")
    User findbyUsername(String username);
}
