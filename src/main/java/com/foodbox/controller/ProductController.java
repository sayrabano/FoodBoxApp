package com.foodbox.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.model.Product;
import com.foodbox.repository.ProductRepository;
import com.foodbox.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200/")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping
	public Product addOrUpdateProduct(@RequestBody Product product) {
		return service.save(product);

	}

	@GetMapping
	public List<Product> getAll() {
		return service.getAllProducts();
	}

	@DeleteMapping("{id}")
	List<Product> delete(@PathVariable Long product_id) {

		service.deleteById(product_id);
		return service.getAllProducts();
	}

	@GetMapping("{product_id}")
	public Product getProductById(@PathVariable Long product_id) {
		return service.findById(product_id);


	}



}
