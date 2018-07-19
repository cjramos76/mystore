package com.example.mystore;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mystore.model.ProductEntity;
import com.example.mystore.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MystoreApplicationTests {

	@Autowired
	ProductService productService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void productListGreatThanFive() {
		List<ProductEntity> productList = this.productService.getProductList();
		assertTrue(productList.size() > 5);
	}
	

}
