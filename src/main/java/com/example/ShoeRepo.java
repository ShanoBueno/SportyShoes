package com.example;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepo extends JpaRepository<Shoe, Integer>{
	@Query("select s from Shoe s where s.category=?1")
	public List<Shoe> findByname(String category);
}