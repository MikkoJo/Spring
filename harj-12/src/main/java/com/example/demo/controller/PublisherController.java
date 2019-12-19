package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
    @RequestMapping("/publishers") 
	public List<Publisher> getPublishers() {
    	return publisherService.getPublishers();
    }

    @RequestMapping("/publishers/{id}") 
	public Publisher getPublisher(@PathVariable Integer id) {
    	return publisherService.getPublisher(id);
    }

    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/publishers"
	)
	public void addPublisher(@RequestBody Publisher publisher) {
    	publisherService.addPublisher(publisher);
    }

    // Kaikki kustantajan yhdellä kertaa
    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/publishers/all"
	)
	public void addPublisher(@RequestBody List<Publisher> publishers) {
    	for (Publisher publisher: publishers) {
    		publisherService.addPublisher(publisher);
    	}
    }

}
