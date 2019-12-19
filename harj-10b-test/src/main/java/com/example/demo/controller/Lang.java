package com.example.demo.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lang {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;
	
	private String name;

	public Lang() {
	}
	
	public Lang(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "Lang [name=" + name + ", code=" + code + "]";
	}

}
