package com.marek.languages.controllers;

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

import com.marek.languages.models.Languages;
import com.marek.languages.services.LanguageService;


@Controller
public class LanguageController {
	//tell controller about service
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String home() {
		
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String getAllLanguages(Model model, @ModelAttribute("languages") Languages languages) {
		List<Languages> allLanguage = this.languageService.allLanguage();
		
		model.addAttribute("allLanguage", allLanguage);
		
		return "index.jsp";
		
	}
	

	
	@PostMapping("/languages/create")
	public String createLanguage(@Valid @ModelAttribute("languages") Languages languages, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Languages> allLanguage = this.languageService.allLanguage();
			
			model.addAttribute("allLanguage", allLanguage);
			return "index.jsp";
		}
		this.languageService.createLanguage(languages);
		
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/info/{id}")
	public String showLanguageInfo(@PathVariable("id") Long id, Model model) {
		Languages l = this.languageService.findLanguage(id);
		
		model.addAttribute("findLanguage", l);
		
		return "show.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String editLanguageInfo(@PathVariable("id")  Long id, @ModelAttribute("languageEdit") Model model) {
		Languages l = this.languageService.findLanguage(id);
		
		model.addAttribute("editLanguage", l);
		
		return "edit.jsp";
	}
	
	@PostMapping("/languages/update/{id}")
	public String updatedLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("languageEdit") Languages languages, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		//if there is no error
		this.languageService.updateLanguague(languages);
		
		return "redirect:/";
	}
	
	@GetMapping("/languages/delete/{id}")
	public String deleteLanguages(@PathVariable("id") Long id) {
		
		this.languageService.deleteLanguage(id);
		
		return "redirect:/";
	}
	
	
	
}
