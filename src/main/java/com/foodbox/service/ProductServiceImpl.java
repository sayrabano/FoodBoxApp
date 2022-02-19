package com.foodbox.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.Product;
import com.foodbox.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository; 

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product save(Product Product) {
		return repository.save(Product);
	}

	@Override
	public void deleteById(Long product_id) {
		repository.deleteById(product_id);
	}

	@Override
	public void update(@Valid Product Product) {
		repository.save(Product);
	}

	@Override
	public Product findById(Long product_id) {
		Optional<Product> bk = repository.findById(product_id);
		if(bk.isPresent())
			return bk.get();
		else
			return new Product();
	}

	
}
