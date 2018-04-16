package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.zufe.rms.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}
