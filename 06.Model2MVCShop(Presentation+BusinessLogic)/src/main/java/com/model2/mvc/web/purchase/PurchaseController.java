package com.model2.mvc.web.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

@Controller
public class PurchaseController {
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;	
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	public PurchaseController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ? : 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ? : 2}")
	int pageSize;
	
	@RequestMapping("/addPurchaseView.do")
	public String addPurchaseView(@RequestParam("prodNo") int prodNo, Model model) throws Exception {
		
		System.out.println("/addPurchaseView.do");
		
		Product product = productService.getProduct(prodNo);
		
		model.addAttribute("product", product);
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
	
	@RequestMapping("/addPurchase.do")
	public String addPurchase(@ModelAttribute("search") Search search, @ModelAttribute("puchase") Purchase purchase, @RequestParam("buyerId") String buyerId, @RequestParam("prodNo") int prodNo, Model model) throws Exception {
		
		System.out.println("/addPurchase.do");
		
		User user = userService.getUser(buyerId);
		
		Product product = productService.getProduct(prodNo);
		
		
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchase.setTranCode("0");
		
		
		
		
		
		
		
		purchaseService.addPurchase(purchase);
		
		
		Map<String, Object> map = purchaseService.getPurchaseList(search, buyerId);
		
		Integer totalPurchase = (Integer)map.get("totalPurchase");
		
		System.out.println("totalPurchase : " + totalPurchase);
		
		
		
		user.setPurchaseAmount(totalPurchase);
		
		userService.updateUser(user);
		
		model.addAttribute("purchase", purchase);
		
		return "forward:/purchase/addPurchase.jsp";
	}
	
	@RequestMapping("/getPurchase.do")
	public String getPurchase(@RequestParam("tranNo") int tranNo, Model model) throws Exception {
		
		System.out.println("/getPurchase.do");
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		
		model.addAttribute("purchase", purchase);
		
		return "forward:/purchase/getPurchase.jsp";
	}
	
	@RequestMapping("/updatePurchaseView.do")
	public String updatePurchaseView(@RequestParam("tranNo") int tranNo, Model model) throws Exception {
		
		System.out.println("/updatePurchaseView.do");
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		
		model.addAttribute("purchase", purchase);
		
		return "forward:/purchase/updatePurchaseView.jsp";
	}
	
	@RequestMapping("/updatePurchase.do")
	public String updatePurchase(@RequestParam("tranNo") int tranNo, @ModelAttribute("puchase") Purchase purchase, Model model) throws Exception {
		
		System.out.println("/updatePurchase.do");
		
		
		purchaseService.updatePurchase(purchase);
		
		Purchase purchase2 = purchaseService.getPurchase(tranNo);
		
		model.addAttribute("purchase", purchase2);
		
		return "forward:/purchase/getPurchase.jsp";
	}
	
	@RequestMapping("/updateTranCode.do")
	public String updateTranCode(@ModelAttribute("search") Search search, @RequestParam("tranNo") int tranNo, @RequestParam("tranCode") String tranCode, @RequestParam("page") int currentPage, HttpServletRequest request, Model model) throws Exception {
		
		System.out.println("/updateTranCode.do");
		
		
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		purchase.setTranCode(tranCode);
		purchaseService.updateTranCode(purchase);
		
		
		
		model.addAttribute("purchase", purchase);
		
		String menu = request.getParameter("menu");
		
		if(menu != null && menu.equals("sale")) {
			return "redirect:/listSale.do?currentPage=" + currentPage;
		} else {
			return "redirect:/listPurchase.do?currentPage=" + currentPage;
		}
	}
	
	@RequestMapping("/listPurchase.do")
	public String listPurchase(@ModelAttribute("search") Search search, Model model, HttpServletRequest request) throws Exception {
		
		System.out.println("/listPurchase.do");
		
		if(search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String buyerId = user.getUserId();
		
		Map<String, Object> map = purchaseService.getPurchaseList(search, buyerId);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalPurchase")).intValue(), pageUnit, pageSize);
		System.out.println("resultPage : " + resultPage);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/purchase/listPurchase.jsp";
	}
	
	@RequestMapping("/listSale.do")
	public String listSale(@ModelAttribute("search") Search search, Model model, HttpServletRequest request) throws Exception {
		
		System.out.println("/listSale.do");
		
		search.setCurrentPage(1);
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null || currentPage == "") {
			
		} else {
			search.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		
		
		search.setPageSize(pageSize);
		
		
		
		Map<String, Object> map = purchaseService.getSaleList(search);
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println("resultPage : " + resultPage);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/purchase/listSale.jsp";
	}
}
