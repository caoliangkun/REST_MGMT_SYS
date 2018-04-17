package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
