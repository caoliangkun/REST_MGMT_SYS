package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
