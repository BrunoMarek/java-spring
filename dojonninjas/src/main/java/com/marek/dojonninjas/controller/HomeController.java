package com.marek.dojonninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.marek.dojonninjas.models.Dojo;
import com.marek.dojonninjas.models.Ninja;
import com.marek.dojonninjas.services.AppService;

@Controller
public class HomeController {
	
	private final AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String home(@ModelAttribute("dojo") Dojo dojo) {
		
		return "index.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "sasas.jsp";
		}
		else {
			this.appServ.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.appServ.findAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
		}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.appServ.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "newNinja.jsp";
			
		}
		else {
			this.appServ.createNinja(ninja);
			return "redirect:/";
		}
		
		
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojoDetails(@PathVariable("id") Long id, Model model) {
		
		Dojo d = this.appServ.getOneDojo(id);
		model.addAttribute("dojo", d);
		
		return "dojoInfo.jsp";
	}
	
	
}
