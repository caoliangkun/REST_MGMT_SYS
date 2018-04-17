package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
