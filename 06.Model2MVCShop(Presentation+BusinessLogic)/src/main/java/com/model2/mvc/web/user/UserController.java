package com.model2.mvc.web.user;

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
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;


//==> 회원관리 Controller
@Controller
public class UserController {
	
	///Field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	//setter Method 구현 않음
		
	public UserController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml 참조 할것
	//==> 아래의 두개를 주석을 풀어 의미를 확인 할것
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	/*
	 * @RequestMapping("/addUserView.do") public String addUserView() throws
	 * Exception {
	 * 
	 * System.out.println("/addUserView.do");
	 * 
	 * return "redirect:/user/addUserView.jsp"; }
	 */
	
	@RequestMapping("/addUserView.do")
	public ModelAndView addUserView() throws Exception {

		System.out.println("/addUserView.do");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/user/addUserView.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/addUser.do") public String addUser( @ModelAttribute("user")
	 * User user ) throws Exception {
	 * 
	 * System.out.println("/addUser.do"); //Business Logic
	 * userService.addUser(user);
	 * 
	 * return "redirect:/user/loginView.jsp"; }
	 */
	
	@RequestMapping("/addUser.do")
	public ModelAndView addUser( @ModelAttribute("user") User user ) throws Exception {

		System.out.println("/addUser.do");
		//Business Logic
		userService.addUser(user);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/user/loginView.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/getUser.do") public String getUser( @RequestParam("userId")
	 * String userId , Model model ) throws Exception {
	 * 
	 * System.out.println("/getUser.do"); //Business Logic User user =
	 * userService.getUser(userId); // Model 과 View 연결 model.addAttribute("user",
	 * user);
	 * 
	 * return "forward:/user/getUser.jsp"; }
	 */
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser( @RequestParam("userId") String userId) throws Exception {
		
		System.out.println("/getUser.do");
		//Business Logic
		User user = userService.getUser(userId);
		// Model 과 View 연결
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/user/getUser.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/updateUserView.do") public String
	 * updateUserView( @RequestParam("userId") String userId , Model model ) throws
	 * Exception{
	 * 
	 * System.out.println("/updateUserView.do"); //Business Logic User user =
	 * userService.getUser(userId); // Model 과 View 연결 model.addAttribute("user",
	 * user);
	 * 
	 * return "forward:/user/updateUser.jsp"; }
	 */
	
	@RequestMapping("/updateUserView.do")
	public ModelAndView updateUserView( @RequestParam("userId") String userId) throws Exception{

		System.out.println("/updateUserView.do");
		//Business Logic
		User user = userService.getUser(userId);
		// Model 과 View 연결
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/user/updateUser.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/updateUser.do") public String
	 * updateUser( @ModelAttribute("user") User user , Model model , HttpSession
	 * session) throws Exception{
	 * 
	 * System.out.println("/updateUser.do"); //Business Logic
	 * userService.updateUser(user);
	 * 
	 * String sessionId=((User)session.getAttribute("user")).getUserId();
	 * if(sessionId.equals(user.getUserId())){ session.setAttribute("user", user); }
	 * 
	 * return "redirect:/getUser.do?userId="+user.getUserId(); }
	 */
	
	@RequestMapping("/updateUser.do")
	public ModelAndView updateUser( @ModelAttribute("user") User user, HttpSession session) throws Exception{

		System.out.println("/updateUser.do");
		//Business Logic
		userService.updateUser(user);
		
		String sessionId=((User)session.getAttribute("user")).getUserId();
		if(sessionId.equals(user.getUserId())){
			session.setAttribute("user", user);
		}
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/getUser.do?userId=" + sessionId);
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/loginView.do") public String loginView() throws Exception{
	 * 
	 * System.out.println("/loginView.do");
	 * 
	 * return "redirect:/user/loginView.jsp"; }
	 */
	
	@RequestMapping("/loginView.do")
	public ModelAndView loginView() throws Exception{
		
		System.out.println("/loginView.do");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/user/loginView.jsp");

		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/login.do") public String login(@ModelAttribute("user") User
	 * user , HttpSession session ) throws Exception{
	 * 
	 * System.out.println("/login.do"); //Business Logic User
	 * dbUser=userService.getUser(user.getUserId());
	 * 
	 * if( user.getPassword().equals(dbUser.getPassword())){
	 * session.setAttribute("user", dbUser); }
	 * 
	 * return "redirect:/index.jsp"; }
	 */
	
	@RequestMapping("/login.do")
	public ModelAndView login(@ModelAttribute("user") User user , HttpSession session ) throws Exception{
		
		System.out.println("/login.do");
		//Business Logic
		User dbUser=userService.getUser(user.getUserId());
		
		if( user.getPassword().equals(dbUser.getPassword())){
			session.setAttribute("user", dbUser);
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/index.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/logout.do") public String logout(HttpSession session )
	 * throws Exception{
	 * 
	 * System.out.println("/logout.do");
	 * 
	 * session.invalidate();
	 * 
	 * return "redirect:/index.jsp"; }
	 */
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session ) throws Exception{
		
		System.out.println("/logout.do");
		
		session.invalidate();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/index.jsp");
		
		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/checkDuplication.do") public String
	 * checkDuplication( @RequestParam("userId") String userId , Model model )
	 * throws Exception{
	 * 
	 * System.out.println("/checkDuplication.do"); //Business Logic boolean
	 * result=userService.checkDuplication(userId); // Model 과 View 연결
	 * model.addAttribute("result", new Boolean(result));
	 * model.addAttribute("userId", userId);
	 * 
	 * return "forward:/user/checkDuplication.jsp"; }
	 */
	
	@RequestMapping("/checkDuplication.do")
	public ModelAndView checkDuplication( @RequestParam("userId") String userId) throws Exception{
		
		System.out.println("/checkDuplication.do");
		//Business Logic
		boolean result=userService.checkDuplication(userId);
		// Model 과 View 연결
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", new Boolean(result));
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("/user/checkDuplication.jsp");

		return modelAndView;
	}
	
	/*
	 * @RequestMapping("/listUser.do") public String
	 * listUser( @ModelAttribute("search") Search search , Model model ,
	 * HttpServletRequest request) throws Exception{
	 * 
	 * System.out.println("/listUser.do");
	 * 
	 * if(search.getCurrentPage() ==0 ){ search.setCurrentPage(1); }
	 * search.setPageSize(pageSize);
	 * 
	 * // Business logic 수행 Map<String , Object>
	 * map=userService.getUserList(search);
	 * 
	 * Page resultPage = new Page( search.getCurrentPage(),
	 * ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
	 * System.out.println(resultPage);
	 * 
	 * // Model 과 View 연결 model.addAttribute("list", map.get("list"));
	 * model.addAttribute("resultPage", resultPage); model.addAttribute("search",
	 * search);
	 * 
	 * return "forward:/user/listUser.jsp"; }
	 */
	
	@RequestMapping("/listUser.do")
	public ModelAndView listUser( @ModelAttribute("search") Search search, HttpServletRequest request) throws Exception{
		
		System.out.println("/listUser.do");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		// Business logic 수행
		Map<String , Object> map=userService.getUserList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("resultPage", resultPage);
		modelAndView.addObject("search", search);
		modelAndView.setViewName("/user/listUser.jsp");
		
		return modelAndView;
	}
}