package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LangController {

	@org.springframework.beans.factory.annotation.Autowired
	private LangService langService;
	
	

	@RequestMapping(value="/langs", method = RequestMethod.GET, produces = 
		{MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public List<Lang> getLangs() {
		return langService.getLangs();
	}
	
	@RequestMapping(value="langs/{code}", method = RequestMethod.GET
			, produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public Lang getLang(@PathVariable String code) {
		return langService.getLang(code);
	}
	
	@RequestMapping(value="/langs", method= RequestMethod.POST)
	public ResponseEntity<String> addLang(@RequestBody Lang lang) {
		System.out.println(lang);
		if(langService.addLang(lang)) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY); 
	}

	@RequestMapping(
			method = RequestMethod.PUT,  
			value = "/langs/{code}"
	)
	public ResponseEntity<String> updateLang(@PathVariable String code, @RequestBody Lang lang) {
		if(langService.updateLang(code, lang)) {
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}
		return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@RequestMapping(
			method = RequestMethod.DELETE,  
			value = "/langs/{code}"
	)
	public ResponseEntity<String> removeLang(@PathVariable String code) {
		if(langService.removeLang(code)) {
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
    	 
}
