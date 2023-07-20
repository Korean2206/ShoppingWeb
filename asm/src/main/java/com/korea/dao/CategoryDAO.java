package com.korea.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    
    @Query("SELECT o FROM Category o WHERE o.gender = ?1")
    List<Category> findByGender(boolean gender);

    @Query("SELECT o FROM Category o WHERE o.gender = ?1 AND o.name LIKE ?2")
    Category findByGenderAndName(boolean gender,String name);
}
