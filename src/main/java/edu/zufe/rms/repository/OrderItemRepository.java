package edu.zufe.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.zufe.rms.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
