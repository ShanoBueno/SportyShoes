package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository

public interface UserRepo extends JpaRepository<User, Long> {
	@Query("select u from User u where u.email=?1")
	public User findByEmail(String email);
}
