package com.nhom5.product.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhom5.product.management.entities.Product;
import com.nhom5.product.management.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/index")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/products")
	public String viewProducts(Model model) {
		List<Product> products = service.getAllProducts();
		model.addAttribute("products",products);
		return "products";
	}
	
	@GetMapping("/newProduct")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "newProduct";
	}
	
	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Product product = service.getProduct(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.deleteProduct(id);
		return "redirect:/products";
	}
}
