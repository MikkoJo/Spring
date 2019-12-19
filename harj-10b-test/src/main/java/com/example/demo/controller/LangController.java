package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LangController {
	
	@org.springframework.beans.factory.annotation.Autowired
	private LangService langService;
	
    @RequestMapping("/langs") 
	public List<Lang> getLangs() {
    	return langService.getLangs();
    }

    @RequestMapping("/langs/{code}") 

	public Lang getLang(@PathVariable String code) {
    	return langService.getLang(code);
    }

    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/langs"
	)
	public void addLang(@RequestBody Lang lang) {
    	langService.addLang(lang);
    }
    
    @RequestMapping(
			method = RequestMethod.PUT,  
			value = "/langs/{code}"
	)
	public void updateLang(@PathVariable String code, @RequestBody Lang lang) {
    	langService.updateLang(code, lang);
    }

    @RequestMapping(
			method = RequestMethod.DELETE,  
			value = "/langs/{code}"
	)
	public void removeLang(@PathVariable String code) {
    	langService.removeLang(code);
    }
	

}
