package com.example.mystore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mystore.model.ProductEntity;

public interface ProductService {
	List<ProductEntity> getProductList();
	ProductEntity getProductById(Long id);
	ProductEntity getProductByName(String name);
}
