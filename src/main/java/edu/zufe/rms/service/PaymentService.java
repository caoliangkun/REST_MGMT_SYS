package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Payment;
import edu.zufe.rms.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository payRepo;

	public List<Payment> findAll() {
		List<Payment> payments = new ArrayList<>();
		for (Payment p : payRepo.findAll()) {
			payments.add(p);
		}
		return payments;
	}

	public Payment save(Payment payment) {
		return payRepo.save(payment);
		
	}
}
