package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LangService {

	List<Lang> langs = new ArrayList<>(Arrays.asList(
			new Lang("Suomi", "fi"), 
			new Lang("Ruotsi", "se"), 
			new Lang("Norja", "no"),
			new Lang("Islanti", "is"), 
			new Lang("Tanska", "de")
			));
	
	public List<Lang> getLangs() {
		return langs;
	}

	public Lang getLang(String code) {
		for(Lang lang: langs) {
			if(lang.getCode().equals(code)) {
				return lang;
			}
		}
		return null;
	}
	
	public Boolean addLang(Lang lang) {
		return langs.add(lang);
	}
	
	public boolean updateLang(String code, Lang lang) {
		for(int i = 0; i < langs.size(); i++) {
			if(langs.get(i).getCode().equals(code)) {
				langs.set(i, lang);
				return true;
			}
		}
		return false;
		
	}

	public boolean removeLang(String code) {
		for(int i = 0; i < langs.size(); i++) {
			if(langs.get(i).getCode().equals(code)) {
				langs.remove(i);
				return true;
			}
		}
		return false;
	}


}
