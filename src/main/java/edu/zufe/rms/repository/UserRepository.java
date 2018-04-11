package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
