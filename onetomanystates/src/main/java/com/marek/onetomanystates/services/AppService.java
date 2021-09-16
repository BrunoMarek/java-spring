package com.marek.onetomanystates.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marek.onetomanystates.models.Resident;
import com.marek.onetomanystates.models.State;
import com.marek.onetomanystates.repositories.ResidentRepo;
import com.marek.onetomanystates.repositories.StateRepo;

@Service
public class AppService {
	//service must know about the repositories
	private final ResidentRepo residentRepo;
	private final StateRepo stateRepo;
	
	
	//constructor for the service initialize
	public AppService(ResidentRepo residentRepo, StateRepo stateRepo) {
		this.residentRepo = residentRepo;
		this.stateRepo = stateRepo;
	}
	
	
	//methods that the service can handle
	public List<State> findAllStates(){
		return (List<State>)this.stateRepo.findAll();
	}
	
	public State crateState(State s) {
		return this.stateRepo.save(s);
	}
	
	public Resident crateResident(Resident r) {
		return this.residentRepo.save(r);
	}
	
	public State getOneState(Long id) {
		return this.stateRepo.findById(id).orElse(null);
	}
	
	
	
	
}
