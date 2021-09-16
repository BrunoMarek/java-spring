package com.marek.springDataPets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marek.springDataPets.models.Pet;
import com.marek.springDataPets.repositories.PetRepository;

@Service
public class PetService {
	
	//tell about the repository
	private final PetRepository petRepository;
	
	//create a constructor for the service 
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
		
	}
	
	//telling services how to access the repository methods
	//get all the pets
	public List<Pet> allPets() {
		return (List<Pet>) this.petRepository.findAll();
		
	}
	
	//create a new pet
	public Pet createPet(Pet pet) {
		return this.petRepository.save(pet);
	}
	
	//find a pet given an id
	public Pet findOnePet(Long id) {
		return this.petRepository.findById(id).orElse(null);
	}
	
	//delete a pet given an id
	public void deletePet(Long id) {
		this.petRepository.deleteById(id);
		
	}
	
	//update a pet by id
	public Pet updatePet(Pet p) {
		
		return this.petRepository.save(p);
		
	}
	
	
	
}
