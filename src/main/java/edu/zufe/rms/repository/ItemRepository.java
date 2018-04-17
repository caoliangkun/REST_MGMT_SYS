package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
