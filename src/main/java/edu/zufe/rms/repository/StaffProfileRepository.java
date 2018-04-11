package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.StaffProfile;

public interface StaffProfileRepository extends CrudRepository<StaffProfile, Long> {
	
}
