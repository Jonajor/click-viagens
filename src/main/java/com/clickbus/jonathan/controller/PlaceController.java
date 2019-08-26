package com.clickbus.jonathan.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickbus.jonathan.model.Place;
import com.clickbus.jonathan.repository.PlaceRepository;

/**
 * @author jonathan
 *
 */

@RestController
@RequestMapping("/clickBus/v1")
public class PlaceController {

	@Autowired
	PlaceRepository placeRepository;

	@GetMapping("/places")
	public List<Place> getAllPlaces() {
		return placeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Place> getById(@PathVariable("id") int id) {
		return placeRepository.findById(id);
	}

	@PostMapping("/place")
	public Place save(@RequestBody @Valid Place place) {
		return placeRepository.save(place);
	}

	@GetMapping("/places/getName/{name}")
	public Place getByName(@PathVariable String name) throws Exception {
		Place p = placeRepository.findByName(name);
		if (p == null)
			throw new Exception("Place not found");
		return p;
	}

	@GetMapping("/places/getCity/{city}")
	public Place getByCity(@PathVariable String city) throws Exception {
		Place p = placeRepository.findByCity(city);
		if (p == null)
			throw new Exception("City not found");
		return p;
	}

	@GetMapping("/places/getNameAndCity/{name}/{city}")
	public Place getByNameAndCity(@PathVariable String name, @PathVariable String city) throws Exception {
		Place place = placeRepository.findByNameAndCity(name, city);
		if (place == null)
			throw new Exception("Place not found");
		return place;
	}

	@GetMapping("/place/getCityAndState/{city}/{state}")
	public Place getByCityAndState(@PathVariable String city, @PathVariable String state) throws Exception {
		Place place = placeRepository.findByCityAndState(city, state);
		if (place == null)
			throw new Exception("Place not found");
		return place;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Place> update(@PathVariable("id") int id, @RequestBody Place place) {
		return placeRepository.findById(id).map(p -> {
			p.setName(place.getName());
			p.setCity(place.getCity());
			p.setLesma(place.getLesma());
			p.setState(place.getState());
			p.setCreationDate(place.getCreationDate());
			p.setUpdateDate(LocalDateTime.now());
			Place updated = placeRepository.save(p);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return placeRepository.findById(id).map(record -> {
			placeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
