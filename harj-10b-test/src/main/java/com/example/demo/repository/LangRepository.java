package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.controller.Lang;

// Tyhjä toteutus riittää tähän harjoitukseen
// Perus CRUD on rajapinnassa valmiiksi toteutettu
public interface LangRepository extends CrudRepository<Lang,String>{
	
}