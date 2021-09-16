package com.marek.dojonninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marek.dojonninjas.models.Dojo;
@Repository
public interface DojoRepo extends CrudRepository<Dojo,Long> {

}
