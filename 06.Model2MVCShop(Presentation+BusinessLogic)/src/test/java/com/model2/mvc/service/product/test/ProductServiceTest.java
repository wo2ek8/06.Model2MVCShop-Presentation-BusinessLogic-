package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.user.UserService;


/*
 *	FileName :  UserServiceTest.java
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		product.setFileName("1111");
		product.setManuDate("01-01-01");
		product.setPrice(2222);
		product.setProdDetail("2222");
		product.setProdName("testAddProduct");
		
		productService.addProduct(product);
		
		
		
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		//10105
		Product product = new Product();
		
		product = productService.getProduct(10033);
		
		Assert.assertEquals("1111", product.getFileName());
		Assert.assertEquals("20010101", product.getManuDate());
		Assert.assertEquals(2222, product.getPrice());
		Assert.assertEquals("2222", product.getProdDetail());
		Assert.assertEquals("testAddProduct", product.getProdName());
		
		Assert.assertNotNull(productService.getProduct(10029));
		Assert.assertNotNull(productService.getProduct(10030));
		
	}
	
	//@Test
	 public void testUpdateProduct() throws Exception{
		 Product product = productService.getProduct(10033);
		 Assert.assertNotNull(product);
		 
		 Assert.assertEquals("1111", product.getFileName());
			Assert.assertEquals("20010101", product.getManuDate());
			Assert.assertEquals(2222, product.getPrice());
			Assert.assertEquals("2222", product.getProdDetail());
			Assert.assertEquals("testAddProduct", product.getProdName());
			
			product.setFileName("5555");
			product.setManuDate("05-05-05");
			product.setPrice(5555);
			product.setProdDetail("5555");
			product.setProdName("testUpdateProduct!!!!222333");
			
			productService.updateProduct(product);
			
			product = productService.getProduct(10033);
			
			Assert.assertNotNull(product);
			
			Assert.assertEquals("5555", product.getFileName());
			Assert.assertEquals("20050505", product.getManuDate());
			Assert.assertEquals(5555, product.getPrice());
			Assert.assertEquals("5555", product.getProdDetail());
			Assert.assertEquals("testUpdateProduct!!!!222333", product.getProdName());
		
	 }
	 
	
	
	 //==>  주석을 풀고 실행하면....
	 //@Test
	 public void testGetProductListAll() throws Exception{
		 Search search = new Search();
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 System.out.println("search : " + search);
		 Map<String, Object> map = productService.getProductList(search);
		 System.out.println("map : " + map);
		 
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 Integer totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("0");
		 search.setSearchKeyword("");
		 map = productService.getProductList(search);
		 System.out.println("search : " + search);
		 System.out.println("map : " + map);
		 
		 list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
	 	
	 }
	 
	 //@Test
	 public void testGetProductListByProdNo() throws Exception{
		 Search search = new Search();
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 System.out.println("search : " + search);
		 Map<String, Object> map = productService.getProductList(search);
		 System.out.println("map : " + map);
		 
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 Integer totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("0");
		 search.setSearchKeyword("2");
		 map = productService.getProductList(search);
		 System.out.println("search : " + search);
		 System.out.println("map : " + map);
		 
		 list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
	 	
	 }
	 
	 //@Test
	 public void testGetProductListByProdName() throws Exception{
		 Search search = new Search();
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 System.out.println("search : " + search);
		 Map<String, Object> map = productService.getProductList(search);
		 System.out.println("map : " + map);
		 
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 Integer totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("1");
		 search.setSearchKeyword("재이");
		 map = productService.getProductList(search);
		 System.out.println("search : " + search);
		 System.out.println("map : " + map);
		 
		 list = (List<Object>)map.get("list");
		 Assert.assertEquals(0, list.size());
		 System.out.println("list : " + list);
		 
		 totalCount = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
	 	
	 }
	 
	 	@Test
		 public void testGetProductListByPrice() throws Exception{
			 Search search = new Search();
			 search.setCurrentPage(1);
			 search.setPageSize(3);
			 System.out.println("search : " + search);
			 Map<String, Object> map = productService.getProductList(search);
			 System.out.println("map : " + map);
			 
			 List<Object> list = (List<Object>)map.get("list");
			 Assert.assertEquals(3, list.size());
			 System.out.println("list : " + list);
			 
			 Integer totalCount = (Integer)map.get("totalCount");
			 System.out.println(totalCount);
			 
			 search.setCurrentPage(1);
			 search.setPageSize(3);
			 search.setSearchCondition("2");
			 search.setSearchKeyword("1111");
			 map = productService.getProductList(search);
			 System.out.println("search : " + search);
			 System.out.println("map : " + map);
			 
			 list = (List<Object>)map.get("list");
			 Assert.assertEquals(0, list.size());
			 System.out.println("list : " + list);
			 
			 totalCount = (Integer)map.get("totalCount");
			 System.out.println(totalCount);
		 	
		 }
}