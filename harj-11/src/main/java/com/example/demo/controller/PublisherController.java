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
    
//    @RequestMapping(
//			method = RequestMethod.PUT,  
//			value = "/publishers/{id}"
//	)
//	public void updatePublisher(@PathVariable String id, @RequestBody Publisher publisher) {
//    	publisherService.updatePublisher(id, publisher);
//    }
//
//    @RequestMapping(
//			method = RequestMethod.DELETE,  
//			value = "/publishers/{id}"
//	)
//	public void removePublisher(@PathVariable String id) {
//    	publisherService.removePublisher(id);
//    }
	

}
