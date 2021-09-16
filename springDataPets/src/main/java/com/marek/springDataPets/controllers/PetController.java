package com.marek.springDataPets.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marek.springDataPets.models.Pet;
import com.marek.springDataPets.services.PetService;

@Controller
public class PetController {
	//tell the controller about the service
	private final PetService petService;
	
	public PetController(PetService petService) {
		this.petService = petService;
		
	}
	
	@RequestMapping("/pets")
	public String getAllPets(Model model) {
		List<Pet> allPets = this.petService.allPets();
		
		model.addAttribute("allPets", allPets);
		
		return "index.jsp";
	}
	
	@GetMapping("/pets/new")
	public String newPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("pet",p);
		return "newPet.jsp";
	}
	
	@PostMapping("/pet/create")
	public String createPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			return "newPet.jsp";
		}
		
		System.out.println(pet.getName());
		System.out.println(pet.getAge());
		System.out.println(pet.getDescription());
		
		this.petService.createPet(pet);
		
		return "redirect:/pets";
	}
	
	@GetMapping("/pet/info/{id}")
	public String showPetInfo(@PathVariable("id") Long id, Model model) {
		//using id from the rout, request pet object from the server
		Pet p = this.petService.findOnePet(id);
		
		model.addAttribute("petToDisplay", p);
		
		return "petinfo.jsp";
	}
	
	@GetMapping("/pets/edit/{id}")
	public String editPet(@PathVariable("id") Long id, Model model) {
		//get a pet object 
		Pet p = this.petService.findOnePet(id);
		
		model.addAttribute("editPet", p);
		
		return "editPet.jsp";
	}
	
	@PostMapping("/pet/update/{id}")
	public String updatedPet(@PathVariable("id") Long id, @Valid @ModelAttribute("petEdit") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			return "editPet";
		}
		//if theres no error
		this.petService.updatePet(pet);
		
		return "redirect:/pets";
		
	}
	
	@GetMapping("/pets/delete/{id}")
	public String deletePet(@PathVariable("id") Long id) {
		
		this.petService.deletePet(id);
		
		return "redirect:/pets";
	}
	
}
