package com.marek.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marek.languages.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository<Languages, Long> {

}
