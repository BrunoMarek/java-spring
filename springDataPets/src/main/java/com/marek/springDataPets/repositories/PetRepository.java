package com.marek.springDataPets.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marek.springDataPets.models.Pet;

@Repository
public interface PetRepository  extends CrudRepository<Pet, Long> {

	
	
	
	
}
