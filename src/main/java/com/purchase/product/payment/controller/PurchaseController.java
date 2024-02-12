package com.purchase.product.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.product.payment.entiy.Purchase;
import com.purchase.product.payment.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchasService;
	
	
	@PostMapping("/createPurchase")
    public ResponseEntity<?> createPurchase(@RequestBody Purchase purchase) {
        try {
            Purchase createdPurchase = purchasService.createPurchase(purchase);
            return ResponseEntity.status(HttpStatus.OK).body(createdPurchase);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate purchase detected: " + e.getMessage());
        }
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
        Optional<Purchase> purchaseOptional = purchasService.getPurchaseById(id);
        return purchaseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
