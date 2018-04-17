package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Customer;

public interface CustomerRepositoty extends CrudRepository<Customer, Long> {

}
