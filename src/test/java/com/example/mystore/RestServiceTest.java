package com.example.mystore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mystore.resource.ProductController;
import com.example.mystore.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class RestServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProductService productService;

	@Test
	public void testProductById() throws Exception {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/product/by-id/8796093054977").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = 	mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			String expected = "{id:8796093054977,name:hybris Munich, Germany}";

			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		}
}
