package com.marek.springDataPets.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marek.springDataPets.models.Pet;
import com.marek.springDataPets.services.PetService;

@RestController
public class PetApi {
	//
	private final PetService petService;
	
	public PetApi(PetService petService) {
		this.petService = petService;
		
	}
	
	//the controller will have requests
	@RequestMapping("/api/pets")
	public List<Pet> getAllPets() {
		return this.petService.allPets();
		
	}
	
	//to create a pet
	@PostMapping("/api/pets")
	public Pet createNewPet(@RequestParam(value="name") String name, @RequestParam(value="age") Integer age, @RequestParam(value="description") String description) {
		
		//create a pet object using the constructor int the Pet.java model
		Pet p = new Pet(name, age, description);
		
		return this.petService.createPet(p);
	}
	
	@GetMapping("/api/pets/{id}")
	public Pet findById(@PathVariable("id") Long id) {
		return this.petService.findOnePet(id);
		
	}
	
	@DeleteMapping("/api/pets/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		this.petService.deletePet(id);
	
		
	}
	
	@PutMapping("/api/pets/update/{id}")
	public Pet updatePet(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="age") Integer age, @RequestParam(value="description") String description) {
		//retrieve pet from db with the id
		Pet p = this.petService.findOnePet(id);
		
		//update that object
		p.setName(name);
		p.setAge(age);
		p.setDescription(description);
		
		//send the updated pet to db
		return this.petService.updatePet(p);
		
		
		
	}
	
	
	
}

