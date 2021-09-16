package com.marek.onetomanystates.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.marek.onetomanystates.models.Resident;
import com.marek.onetomanystates.models.State;
import com.marek.onetomanystates.services.AppService;

@Controller
public class HomeController {
	//let the controller know about the service
	private final AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}
	
	
	@GetMapping("/")
	public String home(Model model, @ModelAttribute("state") State state) {
		List<State> allStates =this.appServ.findAllStates();
		model.addAttribute("allStates", allStates);
		return "index.jsp";
	}
	
	
	@PostMapping("/state/create")
	public String createNewState(@Valid @ModelAttribute("state") State state, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			List<State> allStates =this.appServ.findAllStates();
			model.addAttribute("allStates", allStates);
			return"index.jsp";
		}else {
			
			this.appServ.crateState(state);
			return "redirect:/";
			
		}
		
	}
	
	@GetMapping("/resident/new")
	public String newResident(@ModelAttribute("resident") Resident resident, Model model) {
		//pass list of all states to the populate dropdown
		List<State> allStates =this.appServ.findAllStates();
		model.addAttribute("allStates", allStates);
		return "newResident.jsp";
	}
	
	@PostMapping("/resident/create")
	public String createResident(@Valid @ModelAttribute("resident") Resident resident, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<State> allStates =this.appServ.findAllStates();
			model.addAttribute("allStates", allStates);
			return"newResident.jsp";
		}
		else {
			this.appServ.crateResident(resident);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/state/{id}")
	public String showStateDetails(@PathVariable("id") Long id, Model model) {
		
		State s = this.appServ.getOneState(id);
		model.addAttribute("state", s);
		
		return "stateInfo.jsp";
	}
	
	
	
	
	
	
}