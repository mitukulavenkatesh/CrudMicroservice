package com.example.designPatter.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.designPatter.DTO.PaymentRequestDTO;
import com.example.designPatter.model.PaymentModel;
import com.example.designPatter.services.BillingInterface;
import com.example.designPatter.services.BillingService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class BillingController {

	private final BillingService billingService;

	public BillingController(BillingService billingService) {
		this.billingService = billingService;
	}

	@Autowired(required = false)
	BillingInterface billInterface;

	@PostMapping("/pay")
	public ResponseEntity<?> savePayment(@RequestBody PaymentRequestDTO request) {
		try {
			PaymentModel saved = billingService.savePayment(request);
			return ResponseEntity.ok(saved);
		} catch (RuntimeException ex) {
			return ResponseEntity.badRequest().body(Map.of("status", "FAILED", "message", ex.getMessage()));
		}
	}

//	@GetMapping("/billing")
//	public String getData() {
//		return billingService.billingGet();
//	}

	@PostMapping("/{method}")
	public ResponseEntity<String> paymentData(@PathVariable String method, @RequestParam double amount) {
//		Billing billing = billingService.getPaymentsService(method, amount);
		return ResponseEntity.ok("Payment of ₹" + amount + " done via " + method);
	}

//payment successfully completed
//	@PostMapping("/pay")
//	public ResponseEntity<PaymentModel> getPayDetails(@Valid @RequestBody PaymentModel data) {
//		PaymentModel saved = billingService.debtpay(data);
//		return ResponseEntity.ok(saved);
//	}

	@GetMapping("/getData")
	public ResponseEntity<Map<String, Object>> GetData() {
		Map<String, Object> response = new HashMap<>();
		response.put("months", List.of("Jan", "Feb", "Mar", "Apr", " May", "Jun", "Jul", "Aug"));
		response.put("amounts", List.of(1000, 8000, 3000, 4000, 2000, 6000, 5000, 7000));
		return ResponseEntity.ok(response);

	}
}
