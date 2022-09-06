package com.example;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	@Column
	private String product;
	private String price; 
	private String category; 
	private String username;
	private String shipping;
	@CreationTimestamp
	private LocalDate orderDate; 

}