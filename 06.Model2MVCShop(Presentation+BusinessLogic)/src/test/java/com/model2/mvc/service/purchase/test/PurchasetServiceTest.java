package com.model2.mvc.service.purchase.test;

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
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserDao;
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
public class PurchasetServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	//@Test
	public void testAddPurchase() throws Exception {
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("user01");
		purchase.setBuyer(user);
		purchase.setDivyAddr("0000");
		purchase.setDivyDate("06-06-06");
		purchase.setDivyRequest("0000");
		purchase.setPaymentOption("0");
		Product product = new Product();
		product.setProdNo(10033);
		purchase.setPurchaseProd(product);
		purchase.setReceiverName("공공공공");
		purchase.setReceiverPhone("0000");
		purchase.setTranCode("0");
		
		purchaseService.addPurchase(purchase);
		
		
		
		
		
		
	}
	
	//@Test
	public void testGetPurchase() throws Exception {
		Purchase purchase = new Purchase();
		
		purchase = purchaseService.getPurchase(10004);
		
		/*
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("user01");
		purchase.setBuyer(user);
		purchase.setDivyAddr("0000");
		purchase.setDivyDate("00-01-01");
		purchase.setDivyRequest("0000");
		purchase.setPaymentOption("0");
		Product product = new Product();
		product.setProdNo(10067);
		purchase.setPurchaseProd(product);
		purchase.setReceiverName("공공공공");
		purchase.setReceiverPhone("0000");
		purchase.setTranCode("0");
		*/
		
		Assert.assertEquals(10004, purchase.getTranNo());
		Assert.assertEquals("user01", purchase.getBuyer().getUserId());
		Assert.assertEquals("0000", purchase.getDivyAddr());
		Assert.assertEquals("0000", purchase.getDivyRequest());
		Assert.assertEquals("0", purchase.getPaymentOption().trim());
		Assert.assertEquals(10033, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("공공공공", purchase.getReceiverName());
		Assert.assertEquals("0000", purchase.getReceiverPhone());
		Assert.assertEquals("0", purchase.getTranCode().trim());
		
		Assert.assertNotNull(purchaseService.getPurchase(10000));
		Assert.assertNotNull(purchaseService.getPurchase(10001));
		
	}
	
	@Test
	 public void testGetPurchaseList() throws Exception{
		 Search search = new Search();
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 String buyerId = "user02";
		 System.out.println("buyerId : " + buyerId);
		 Map<String, Object> map = purchaseService.getPurchaseList(search, buyerId);
		 System.out.println("map : " + map);
		
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 Integer totalPurchase  = (Integer)map.get("totalPurchase");
		 System.out.println("totalPurchase : " + totalPurchase);
		 
		 
	 }
	 
	
	
	 //==>  주석을 풀고 실행하면....
	 //@Test
	 public void testGetSaleList() throws Exception{
		 Search search = new Search();
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 Map<String, Object> map = purchaseService.getSaleList(search);
		 System.out.println("map : " + map);
		
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 System.out.println("list : " + list);
		 
		 Integer totalCount  = (Integer)map.get("totalCount");
		 System.out.println(totalCount);
	 	
	 }
	 
	 //@Test
	 public void testUpdatePurchase() throws Exception{
		 Purchase purchase = purchaseService.getPurchase(10004);
		 Assert.assertNotNull(purchase);
		 /*
			Purchase purchase = new Purchase();
			User user = new User();
			user.setUserId("user01");
			purchase.setBuyer(user);
			purchase.setDivyAddr("0000");
			purchase.setDivyDate("00-01-01");
			purchase.setDivyRequest("0000");
			purchase.setPaymentOption("0");
			Product product = new Product();
			product.setProdNo(10067);
			purchase.setPurchaseProd(product);
			purchase.setReceiverName("공공공공");
			purchase.setReceiverPhone("0000");
			purchase.setTranCode("0");
			*/
		 /*
		 Assert.assertEquals(10088, purchase.getTranNo());
			Assert.assertEquals("user01", purchase.getBuyer().getUserId());
			Assert.assertEquals("0000", purchase.getDivyAddr());
			Assert.assertEquals("0000", purchase.getDivyRequest());
			Assert.assertEquals("0", purchase.getPaymentOption().trim());
			Assert.assertEquals(10067, purchase.getPurchaseProd().getProdNo());
			Assert.assertEquals("공공공공", purchase.getReceiverName());
			Assert.assertEquals("0000", purchase.getReceiverPhone());
			Assert.assertEquals("0", purchase.getTranCode().trim());
			*/
			
			purchase.setDivyAddr("8888");
			purchase.setDivyRequest("8888");
			purchase.setPaymentOption("1");
			purchase.setReceiverName("팡팡파라");
			purchase.setReceiverPhone("8888");
			purchase.setDivyDate("08-08-08");
			
			purchaseService.updatePurchase(purchase);
			
			
			purchase = purchaseService.getPurchase(10004);
			Assert.assertNotNull(purchase);
			
			Assert.assertEquals("8888", purchase.getDivyAddr());
			Assert.assertEquals("8888", purchase.getDivyRequest());
			Assert.assertEquals("1", purchase.getPaymentOption().trim());
			Assert.assertEquals("팡팡파라", purchase.getReceiverName());
			Assert.assertEquals("8888", purchase.getReceiverPhone());
			
	 }
	 
	 //@Test
	 public void testUpdateTrancode() throws Exception{
		 Purchase purchase = new Purchase();
		 purchase = purchaseService.getPurchase(10004);
		 Assert.assertNotNull(purchase);
		 
		 purchase.setTranCode("1");
		 
		 purchaseService.updateTranCode(purchase);
		 
		 
		 purchase = purchaseService.getPurchase(10004);
		 Assert.assertEquals("1", purchase.getTranCode().trim());
	 	
	 }
	 
	
}