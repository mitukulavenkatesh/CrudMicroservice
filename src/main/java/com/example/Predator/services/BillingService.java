package com.example.designPatter.services;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.example.designPatter.DTO.PaymentRequestDTO;
import com.example.designPatter.model.PaymentModel;
import com.example.designPatter.model.UserModel;
import com.example.designPatter.repository.BillingRepository;
import com.example.designPatter.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BillingService {

//	private static final Logger logger = LoggerFactory.getLogger(BillingService.class);
//	private final Map<String, BillingService> paymentMap;

	private final UserRepository userRepository;
	private final BillingRepository billingRepository;

	public BillingService(UserRepository userRepository, BillingRepository billingRepository) {
		this.userRepository = userRepository;
		this.billingRepository = billingRepository;
	}

	@Transactional
	public PaymentModel savePayment(PaymentRequestDTO request) {
		UserModel user = new UserModel();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user = userRepository.save(user);
		System.out.println("=====--" + user.getId());

		PaymentModel payment = new PaymentModel(null, user, request.getCard().getName(),
				request.getCard().getCardNumber(), request.getCard().getExpiry(), request.getCard().getCvv(),
				OffsetDateTime.now());
		boolean checkStatus = paymentGateway();
		if (!checkStatus) {
			throw new RuntimeException("Payment Failed — Rolling back user + payment.");
		}
		payment = billingRepository.save(payment);
		return payment;
	}

	private boolean paymentGateway() {
		return true;
	}

}
