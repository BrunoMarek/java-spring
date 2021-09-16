package com.marek.onetomanystates.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marek.onetomanystates.models.Resident;

public interface ResidentRepo extends CrudRepository<Resident,Long> {
	

}
