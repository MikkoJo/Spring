package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.LangRepository;

@Component
public class LangService {
	
	 @Autowired
	private LangRepository repo;
			

	public List<Lang> getLangs() {
		List<Lang> langs = new ArrayList<>();
		Iterable<Lang> languages = repo.findAll();
		
		for (Lang l: languages) {
			langs.add(l);
		}
		return langs;
	}
	
	public Lang getLang(String code) {
		return repo.findById(code).get();		
	}

	public void addLang(Lang lang) {
		repo.save(lang);
	}

	// Poistaminen tehdään vain, jos löydetään poistettava alkio
	public void removeLang(String code) {
		Optional<Lang> found = repo.findById(code);
		if (found.isPresent()) {
			repo.deleteById(code);
		}
	}

	public void updateLang(String code, Lang lang) {
		// Osaa id:n perusteella tallentaa tietokantaan joko vanhan päälle tai kokonaan uuden alkion
		repo.save(lang);		
	}

}
