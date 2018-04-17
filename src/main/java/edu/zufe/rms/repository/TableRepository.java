package edu.zufe.rms.repository;


import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Table;

public interface TableRepository extends CrudRepository<Table, Long> {

}
