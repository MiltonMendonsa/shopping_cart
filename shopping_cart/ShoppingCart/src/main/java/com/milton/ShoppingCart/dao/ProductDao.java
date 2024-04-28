package com.milton.ShoppingCart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.milton.ShoppingCart.dto.Product;
import com.milton.ShoppingCart.repository.ProductRepository;

@Repository
public class ProductDao 
{
	@Autowired
	ProductRepository productRepository;
	
	//to insert object into DB
	public String addProduct(Product product)
	{
		productRepository.save(product);
		return "Product added to cart Successfully...";
	}
	
	//to fetch all items
	public List<Product> fetchAll()
	{
		return productRepository.findAll();
	}
	
	//to fetch by id
	public Product fetchById(int productId)
	{
		Optional<Product> op = productRepository.findById(productId);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
	}
	
	
	//delete an object
	public String deleteProduct(int productId)
	{
		Product p = fetchById(productId);
		if(p != null)
		{
			String productName = p.getProductName();
			productRepository.delete(p); //or  productRepository.deleteById(productId);
			return productName+" product is deleted from cart";
		}
		return "product not available in cart";
	}
	
	
	//update an object in cart
	public Product updateQuantity(int productId, int newQuantity)
	{
		Product p = fetchById(productId);
		if(p != null)
		{
			p.setQuantity(newQuantity);
			productRepository.save(p);
			return p;
		}
		return null;
	}
	
}
