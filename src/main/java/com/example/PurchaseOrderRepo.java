package com.example;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {
	@Query("select po from PurchaseOrder po order by po.orderDate desc")
	public List<PurchaseOrder> findByDate();
	
	@Query("select po from PurchaseOrder po where po.category=?1")
	public List<PurchaseOrder> findByname(String category);
	
	@Query("select p from PurchaseOrder p where p.username=?1")
	public List<PurchaseOrder> findPurchaseByEmail(String username);

}
