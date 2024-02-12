package com.purchase.product.payment.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchase.product.payment.entiy.Purchase;
import com.purchase.product.payment.repo.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepo purchaseRepo;
	
	public Purchase createPurchase(Purchase purchase) {
		purchase.setOrderDateandTime(LocalDateTime.now());
		purchase.setOrderId(UUID.randomUUID().toString());
		
		/*
		 * Purchase existingEmail=purchaseRepo.findByemail(purchase.getemail());
		 * if(existingEmail!=null) { throw new
		 * RuntimeException("Duplicate purchase detected for email "
		 * +purchase.getemail()); }
		 */		
		return purchaseRepo.save(purchase);
	}
	
	public Optional<Purchase> getPurchaseById(Long id){
		return purchaseRepo.findById(id);
	}

}
