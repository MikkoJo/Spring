package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lang implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	@Id
	private String code;
	
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
