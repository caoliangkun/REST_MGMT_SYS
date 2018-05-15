package edu.zufe.rms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.zufe.rms.model.Favorite;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {

}
