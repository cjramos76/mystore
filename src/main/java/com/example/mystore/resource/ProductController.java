package com.example.mystore.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mystore.model.ProductEntity;
import com.example.mystore.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path="/product/list")
	@ModelAttribute("productList")
	public ModelAndView  list() {
		List<ProductEntity> productList = this.productService.getProductList();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("productList", productList);
        return mav;

	}
	
	@GetMapping(path="/product/by-id/{id}")
	public ModelAndView productById(@PathVariable Long id) {
		ProductEntity product = this.productService.getProductById(id);
		return this.getProductById(product);
	}

	@PostMapping(path="/product/by-name")
	public ModelAndView productById(@RequestParam("name") String name) {
		ProductEntity product = this.productService.getProductByName(name);
		return this.getProductById(product);
	}
	
	private ModelAndView getProductById(ProductEntity product) {
		if (product == null) {
			return new ModelAndView("detail").addObject(new ProductEntity());
		} else {
	        return new ModelAndView("detail").addObject("product", product);
		}
	}



}
