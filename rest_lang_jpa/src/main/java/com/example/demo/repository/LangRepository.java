package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Lang;
public interface LangRepository extends CrudRepository<Lang, String> {

}
