package com.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PurchaseOrderController {
	@Autowired
	ShoeRepo shoeRepo; 

	@Autowired
	PurchaseOrderRepo poRepo;
	
	@GetMapping("/createPO/{id}")
	public String addPOForm(@PathVariable("id") int id,  PurchaseOrder purchaseOrder, Shoe shoe, Model model) {
		Optional<Shoe> s = shoeRepo.findById(id);
			if (s.isPresent()) {
				model.addAttribute("shoe", s.get());
			}
		
		return "addPurchase"; 
	}
	
	@GetMapping("/orderConfirmed")
	public String orderConfirmed() {
	return "orderConfirmed";
	}
	
	@PostMapping("/createPurchase")
	public String addShoe(PurchaseOrder purchase, Model model) {
		poRepo.save(purchase);
		return "redirect:/orderConfirmed"; 
	}
	
	
	@GetMapping("/admin/getPOs")
	public String get(Model model){
		
	
		System.out.println(shoeRepo.findAll());

		model.addAttribute("purchaseOrder", poRepo.findAll());
		return "pos";
	}
	@GetMapping("/getByDate")
	public String findByDate(Model model) {

		model.addAttribute("purchaseOrder", poRepo.findByDate());
		
		return "getByDate"; 
	}
	
	@GetMapping("/getPurchaseHistory/{email}")
	public String findbyEmail(@PathVariable String email, Model model) {
		model.addAttribute("purchaseOrder", poRepo.findPurchaseByEmail(email));
		return "userPurchases"; 
	}
	
	
@GetMapping("/getPoCategory/{category}")
public String findbycategory(@PathVariable String category, Model model) {
	model.addAttribute("purchaseOrder", poRepo.findByname(category));
	return "getPoCategory"; 
}
	
	

}