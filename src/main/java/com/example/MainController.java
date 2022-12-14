package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	UserRepo userRepo; 
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String home() {
		return "admin" ;
	}
	
	@GetMapping("/user")
	public String userHome() {
		return "user"; 
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getCategory(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		
		String res = request.getParameter("email");
		User u = userRepo.findByEmail(res);
		mv.addObject("user", u); 
		mv.setViewName("usersByEmail"); 
		return mv;
	}
	
	
		
	

}
