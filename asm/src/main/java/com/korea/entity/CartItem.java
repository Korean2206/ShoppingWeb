package com.korea.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cart_items")
public class CartItem {
    @Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
    @ManyToOne
    @JoinColumn(name = "productID")
    Product product;
    int quantity = 1;
    @ManyToOne
    @JoinColumn(name="cartID")
    Cart cart;
 
    


}
