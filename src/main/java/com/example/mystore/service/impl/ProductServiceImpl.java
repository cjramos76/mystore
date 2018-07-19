package com.example.mystore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mystore.model.ProductEntity;
import com.example.mystore.repository.ProductRepository;
import com.example.mystore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> getProductList() {
		return StreamSupport.stream(productRepository.findByIdNotNullAndNameNotNullAndDateNotNull().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	public ProductEntity getProductById(Long id) {
		return productRepository.findOne(id);
	}
	
	public ProductEntity getProductByName(String name) {
		return productRepository.findByName(name);
	}

}
