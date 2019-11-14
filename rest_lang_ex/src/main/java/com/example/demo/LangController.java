package com.example.demo;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LangController {

	List<Lang> langs = Arrays.asList(
			new Lang("Suomi", "fi"), 
			new Lang("Ruotsi", "se"), 
			new Lang("Norja", "no"),
			new Lang("Islanti", "is"), 
			new Lang("Tanska", "de")
			);

	@RequestMapping(value="/langs/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Lang> getLangsJson() {
		return langs;
	}
	
	@RequestMapping(value="/langs", produces = MediaType.TEXT_HTML_VALUE)
	public String getLangs() {
		String response = "<html><head></head><body>" +
						"<table border='4'><tr><th>Country</th><th>Code</th></tr>";
		for(Lang l: langs) {
			response += "<tr><td>" + l.getName() + "</td><td>" + l.getCode() + "</td></tr>";
		}
		response += "</table></body></html>";
		return response;
	}
	
	@RequestMapping(value="/langs/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<Lang> getLangsXml() {
		return langs;
	}

}
