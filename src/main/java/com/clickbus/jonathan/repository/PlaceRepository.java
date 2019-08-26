package com.clickbus.jonathan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickbus.jonathan.model.Place;

/**
 * @author jonathan
 *
 */
public interface PlaceRepository extends JpaRepository<Place, Integer>{

	public Optional<Place> findById(Integer id);
	public List<Place> findAll();
	public Place save(Place place);
	public Place findByName(String name);
	public Place findByCity(String city);
	public Place findByNameAndCity(String name, String city);
	public Place findByCityAndState(String city, String state);
}
