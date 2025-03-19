package com.example.persistenceDemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	private final PurchaseRepository pr;
	PurchaseController(PurchaseRepository pr){
		this.pr=pr;
	}
	@PostMapping
	public void storePurchase (@RequestBody Purchase purchase) {
		pr.storePurchase(purchase);
	}
	@GetMapping
	public List<Purchase> getpurchases(){
		return pr.findAllPurchases();
	}
}
