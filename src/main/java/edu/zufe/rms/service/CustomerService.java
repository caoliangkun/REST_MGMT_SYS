package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	
	public Customer saveCust(Customer cust) {
		return custRepo.save(cust);
	}

}
