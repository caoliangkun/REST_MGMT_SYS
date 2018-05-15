package edu.zufe.rms.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Payment;
import edu.zufe.rms.repository.PaymentRepository;
import edu.zufe.rms.util.SortUtil;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository payRepo;

	public List<Payment> findAll(String year) {
		List<Payment> payments = new ArrayList<>();
		for (Payment p : payRepo.findAll()) {
			if (p.getPayAt() != null) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(p.getPayAt());
				if (calendar.get(Calendar.YEAR) == Integer.valueOf(year)) {
					payments.add(p);
				}
			}
		}
		return payments;
	}
	
	public List<Payment> findAll() {
		List<Payment> payments = new ArrayList<>();
		for (Payment p : payRepo.findAll()) {
					payments.add(p);
		}
		SortUtil.sortByPayDate(payments);
		return payments;
	}

	public Payment save(Payment payment) {
		return payRepo.save(payment);

	}
}
