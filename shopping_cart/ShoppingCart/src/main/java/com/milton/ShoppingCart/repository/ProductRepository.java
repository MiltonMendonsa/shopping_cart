package com.milton.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milton.ShoppingCart.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
