package com.marek.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marek.languages.models.Languages;
import com.marek.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	//tell about the repository
	private final LanguageRepository languageRepository;
	
	//create a constructor for the service
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	//telling services how to access the repository methods
	//get all the 
	public List<Languages> allLanguage() {
		return (List<Languages>) this.languageRepository.findAll();
	}
	
	//create a new language
	public Languages createLanguage (Languages languages) {
		return this.languageRepository.save(languages);
	}
	
	//find a language by id
	public Languages findLanguage (Long id) {
		return this.languageRepository.findById(id).orElse(null);
	}
	
	//delete a language by id
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
	
	//update by id
	public Languages updateLanguague(Languages l) {
		return this.languageRepository.save(l);
	}
	
	
}
	
