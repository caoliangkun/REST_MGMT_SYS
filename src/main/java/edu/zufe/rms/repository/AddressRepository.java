package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
