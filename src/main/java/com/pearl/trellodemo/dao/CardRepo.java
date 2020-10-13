package com.pearl.trellodemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.pearl.trellodemo.model.Card;

public interface CardRepo extends CrudRepository<Card, String> {
	
	

}
