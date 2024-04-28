package com.milton.ShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milton.ShoppingCart.dao.ProductDao;
import com.milton.ShoppingCart.dto.Product;

@RestController
public class ProductController 
{
	@Autowired
	ProductDao productDao;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product)
	{
		return productDao.addProduct(product);
	}
	
	
	@GetMapping("/getall")
	public List<Product> fetchAll()
	{
		return productDao.fetchAll();
	}
	
	
	@GetMapping("/fetchById")
	public Product fetchById(@RequestParam int productId)
	{
		return productDao.fetchById(productId);
	}
	
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int productId)
	{
		return productDao.deleteProduct(productId);
	}
	
	
	@PutMapping("/updateQuantity")
	public Product updateProduct(@RequestParam int productId, @RequestParam int quantity)
	{
		return productDao.updateQuantity(productId, quantity);
	}
}
