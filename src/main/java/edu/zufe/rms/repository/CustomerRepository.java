package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
