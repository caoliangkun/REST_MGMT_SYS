package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.zufe.rms.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
