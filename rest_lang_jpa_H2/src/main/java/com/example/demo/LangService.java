package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.LangRepository;

@Component
public class LangService {


	@Autowired
	private LangRepository repo;
	public List<Lang> getLangs() {
		return (List<Lang>) repo.findAll();
	}

	public Lang getLang(String code) {
		Optional<Lang> lang = repo.findById(code);
		if(lang.isPresent()) {
			return lang.get();
		}
		return null;
	}
	
	public void addLang(Lang lang) {
		repo.save(lang);
	}
	
	public void updateLang(String code, Lang lang) {
		repo.save(lang);
		
	}

	public void removeLang(String code) {
		repo.deleteById(code);
	}


}
