package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LangController {

	@org.springframework.beans.factory.annotation.Autowired
	private LangService langService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/langs", method = RequestMethod.GET, produces = 
		{MediaType.APPLICATION_JSON_VALUE
	})
	public List<Lang> getLangs() {
		return langService.getLangs();
	}
//	public ResponseEntity<List<Lang>> getLangs() {
//		return new ResponseEntity(langService.getLangs(), HttpStatus.OK);
//	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="langs/{code}", method = RequestMethod.GET
			, produces = {MediaType.APPLICATION_JSON_VALUE
			})
	public Lang getLang(@PathVariable String code) {
		return langService.getLang(code);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/langs", method= RequestMethod.POST)
	public ResponseEntity<String> addLang(@RequestBody Lang lang) {
		langService.addLang(lang);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			method = RequestMethod.PUT,  
			value = "/langs/{code}"
	)
	public ResponseEntity<String> updateLang(@PathVariable String code, @RequestBody Lang lang) {
		if(!lang.getCode().equals(code)) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		langService.updateLang(code, lang);
		return new ResponseEntity<String>(HttpStatus.OK);
			
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(
			method = RequestMethod.DELETE,  
			value = "/langs/{code}"
	)
	public ResponseEntity<String> removeLang(@PathVariable String code) {
		langService.removeLang(code);
		return new ResponseEntity<String>(HttpStatus.OK);
			
		
	}
    	 
}
