package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.PublisherRepository;


@Component
public class PublisherService {

	@Autowired
	private PublisherRepository repo;

	public List<Publisher> getPublishers() {
		List<Publisher> publishers = new ArrayList<>();
		Iterable<Publisher> publisherIter = repo.findAll();
		publisherIter.forEach(publishers::add);
		return publishers;
	}

	public Publisher getPublisher(Integer id) {
		return repo.findById(id).get();
	}

	public void addPublisher(Publisher publisher) {
		repo.save(publisher);
	}


}
