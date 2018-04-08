package edu.zufe.rms.service.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.domain.model.StaffProfile;

public interface StaffProfileRepository extends CrudRepository<StaffProfile, Long> {
	
}
