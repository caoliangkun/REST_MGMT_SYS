package edu.zufe.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.zufe.rms.model.StaffProfile;
import edu.zufe.rms.repository.StaffProfileRepository;

@Service
public class StaffProfileService {
	@Autowired
	StaffProfileRepository staffRepository;
	
	@RequestMapping(path = "/saveStaff")
	StaffProfile saveStaff(StaffProfile staff) {
		return staffRepository.save(staff);
	}
}
