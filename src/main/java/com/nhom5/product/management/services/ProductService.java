package com.nhom5.product.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom5.product.management.entities.Product;
import com.nhom5.product.management.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public void saveProduct(Product product) {
		repository.save(product);
	}
	
	public Product getProduct(Integer id) {
		return repository.getById(id);
	}
	
	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}
}
