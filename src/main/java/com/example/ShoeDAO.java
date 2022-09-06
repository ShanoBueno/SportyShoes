package com.example;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ShoeDAO {
	@Autowired
	ShoeRepo shoeRepo;
	
	// insert
	public Shoe insert(Shoe shoe) {
		return shoeRepo.save(shoe);
	}
	
	// get the shoes
	public List<Shoe> getShoe(){
		return shoeRepo.findAll();
	}
	
	
	// Delete a shoe by id
	public String deleteById(int id) {
		shoeRepo.deleteById(id);
		return "Deleted the product with the id of " + id;
	}
	
	//Update a shoe's attributes
	public Shoe update(int id ,Shoe shoe) {
		Shoe s = shoeRepo.findById(id).orElse(null);
		s.setName(shoe.getName());
		s.setCategory(shoe.getCategory());
		s.setPrice(shoe.getPrice());
		return shoeRepo.save(s);
	}
	
	// Find a user by category
	public List<Shoe> findbyname(String category) {
		return shoeRepo.findByname(category);
	}
}
