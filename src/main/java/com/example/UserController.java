package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserController {
	@Autowired
	UserRepo userrepo;
	

	@GetMapping("/admin/getUsers")
	public String get(Model model){
		model.addAttribute("User", userrepo.findAll());
		return "Users";
	}
	
	
	
	

}
