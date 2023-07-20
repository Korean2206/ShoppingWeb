package com.korea.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.korea.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    
    @Query("SELECT o FROM Product o WHERE o.category.gender = ?1")
    Page<Product> findByGender(boolean gender,Pageable pageable);
    
    @Query(value="select * from products "
    +"where id in (select top 4 productid from orderdetails "
    +"group by productID "
    +"order by COUNT(quantity) desc)",nativeQuery = true)
    List<Product> finByBestSeller();

    @Query("SELECT o FROM Product o WHERE o.category.gender = ?1 AND (o.category.name LIKE ?2 OR o.category.name LIKE ?3)")
    Page<Product> findByGenderAndCategory(boolean gender,String name1,String name2,Pageable pageable);

    @Query("SELECT o FROM Product o WHERE o.id = ?1")
    Product findByID(Integer id);

    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeyword(String name,Pageable pageable);
}
