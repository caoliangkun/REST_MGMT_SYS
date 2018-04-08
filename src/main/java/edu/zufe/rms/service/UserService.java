package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zufe.rms.domain.model.User;
import edu.zufe.rms.service.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User CreateUser(String name, String password, String phone) {
		User user = new User(name, password, phone);
		return userRepository.save(user);
	}
	
	public Iterable<User> findAll() {
		Iterable<User> users;
		users =  userRepository.findAll();
		return users;
	}

	public User findByAccount(String account) {
		for (User user: userRepository.findAll()) {
			if (user.getPhone().equals(account)) {
				return user;
			}
		}
		return null;
	}
}
