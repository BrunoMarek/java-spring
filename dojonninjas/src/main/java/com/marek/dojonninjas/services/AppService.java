package com.marek.dojonninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marek.dojonninjas.models.Dojo;
import com.marek.dojonninjas.models.Ninja;
import com.marek.dojonninjas.repositories.DojoRepo;
import com.marek.dojonninjas.repositories.NinjaRepo;

@Service
public class AppService {
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public AppService(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	
	//methods
	public List<Dojo> findAllDojos() {
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return this.dojoRepo.save(d);
	}
	
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);

	}
	
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
