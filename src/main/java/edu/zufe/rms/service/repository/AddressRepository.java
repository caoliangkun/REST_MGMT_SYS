package edu.zufe.rms.service.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.domain.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
