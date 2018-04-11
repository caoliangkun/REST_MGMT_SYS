package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.model.User;
import edu.zufe.rms.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	UserRepository userRepository;

	public boolean login(String account, String password) {
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
}
