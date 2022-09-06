package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepo catRepo;
	@Autowired
	CategoryDAO catDAO;
	
	@GetMapping("/admin/createCatGet")
    public String addCatForm(Category cat) {
        return "addCategory";
    }
	
	@PostMapping("/createCategory")
	public String addCat(Category cat, Model model) {
		
		
		catRepo.save(cat);
		return "redirect:/admin/createShoeGet";
	}
	
	@GetMapping("/getAllCategories")
	public String get(Model model){
		List<Category> cat = new ArrayList<Category>(catDAO.getCategory());
		model.addAttribute("cat", catRepo.findAll());
		return "cat";
	}
	
	
}
