package com.model2.mvc.web.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Review;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.review.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	@Qualifier("reviewServiceImpl")
	private ReviewService reviewService;
	
	public ReviewController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ? : 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ? : 2}")
	int pageSize;
	
	@RequestMapping("/addReview.do")
	public String addReview(@RequestParam("userReview") String userReview, Model model, HttpSession session, @RequestParam("prodNo") int prodNo) throws Exception {
		System.out.println("/addReview.do");
		
		Review review = new Review();
		
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();
		
		review.setUserId(userId);
		review.setProdNo(prodNo);
		review.setUserReview(userReview);
		
		System.out.println("review : " + review);
		
		reviewService.addReview(review);
		
		
		
		
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/listReview.do")
	public String listReview() throws Exception {
		System.out.println("/listReview.do");
		return "";
	}
}