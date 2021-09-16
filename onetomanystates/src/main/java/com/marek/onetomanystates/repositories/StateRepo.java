package com.marek.onetomanystates.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marek.onetomanystates.models.State;

@Repository
public interface StateRepo extends CrudRepository<State, Long> {
	//extends to crud
}
