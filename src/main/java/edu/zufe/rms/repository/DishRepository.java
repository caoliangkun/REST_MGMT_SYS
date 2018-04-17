package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.zufe.rms.model.Dish;

public interface DishRepository extends CrudRepository<Dish, Long> {

}
