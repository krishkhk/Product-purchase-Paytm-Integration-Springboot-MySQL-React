package com.purchase.product.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purchase.product.payment.entiy.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long>{
	
	Purchase findByemail(String email);
	
}
