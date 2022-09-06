package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeController {
	@Autowired
	ShoeRepo shoeRepo;
	
	@Autowired
	ShoeDAO shoeDAO;
	
	@Autowired
	CategoryRepo catRepo; 
	
	@GetMapping("/admin/createShoeGet")
    public String addShoeForm(Shoe Shoe, Model model) {
		model.addAttribute("category", catRepo.findAll()); 
        return "addShoe";
    }
	
	@PostMapping("/createShoe")
	public String addShoe(Shoe Shoe, Model model) {
		
		
		shoeRepo.save(Shoe);
		return "redirect:/getAllShoe";
	}
	@GetMapping("/getAllShoe")
	public String get(Model model){
		List<Shoe> shoe = new ArrayList<Shoe>(shoeDAO.getShoe());
		System.out.println(shoeRepo.findAll());
		model.addAttribute("shoe", shoeRepo.findAll());
		return "shoe";
	}
	
	@GetMapping("/getAllShoeUser")
	public String getShoe(Model model){
		List<Shoe> shoe = new ArrayList<Shoe>(shoeDAO.getShoe());
		System.out.println(shoeRepo.findAll());
		model.addAttribute("shoe", shoeRepo.findAll());
		return "shoeUser";
	}
	
	
	
	
	
	
	
	@GetMapping("/admin/edit/{id}")
	public String shoeUpdateForm(@PathVariable("id") int id, Model model) {
	    Shoe shoe = shoeRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid shoe Id:" + id));
	    model.addAttribute("category", catRepo.findAll()); 
	    model.addAttribute("shoe", shoe);
	    return "shoeUpdateForm";
	}
	
@GetMapping("/getByCategory/{category}")
public String findbycategory(@PathVariable String category, Model model) {
	model.addAttribute("shoe", shoeRepo.findByname(category));
	return "getByCategory"; 
}

@GetMapping("/getByCategoryUser/{category}")
public String findbycategoryUser(@PathVariable String category, Model model) {
	model.addAttribute("shoe", shoeRepo.findByname(category));
	return "getByCategoryUser"; 
}
	
	
	
	@PostMapping("/admin/update/{id}")
	public String updateShoe(@PathVariable("id") int id, Shoe shoes, Model model) {
		model.addAttribute("category", catRepo.findAll());     
	        
	    shoeRepo.save(shoes);
	    return "redirect:/getAllShoe";
	}
	
	
	@GetMapping("/admin/delete/{id}")
    public String deleteShoe(@PathVariable("id") int id) {
        Shoe shoe = shoeRepo.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Invalid shoe Id:" + id));
        shoeRepo.delete(shoe);
        return "redirect:/getAllShoe";
    }
	
	
	
	
}

