package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.Customer;
import edu.zufe.rms.model.User;
import edu.zufe.rms.repository.CustomerRepository;
import edu.zufe.rms.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CustomerRepository custRepo;

	public boolean loginUser(String account, String password) {
		Iterable<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getPhone().equals(account)) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean loginCust(String account, String password) {
		Iterable<Customer> custs = custRepo.findAll();
		for (Customer cust : custs) {
			if (cust.getPhone().equals(account)) {
				if (cust.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}
