package com.example.mystore.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mystore.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	Iterable<ProductEntity> findByIdNotNullAndNameNotNullAndDateNotNull();
	ProductEntity findByName(String name);

}
