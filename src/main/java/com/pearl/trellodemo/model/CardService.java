package com.pearl.trellodemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearl.trellodemo.dao.CardRepo;

@Service
public class CardService {
	@Autowired
    CardRepo repo;
     
	/*
	 * The below method returns all cards 
	 */
    public List<Card> getAllCards()
    {
        List<Card> cardList = (List<Card>) repo.findAll();
         
        if(cardList.size() > 0) {
            return cardList;
        } else {
            return new ArrayList<Card>();
        }
    }
     
    public Card getCardById(String title) throws Exception 
    {
        Optional<Card> card = repo.findById(title);
         
        if(card.isPresent()) {
            return card.get();
        } else {
            throw new Exception("No card record exist for given id");
        }
    }
     
    public Card createOrUpdateCard(Card card) throws Exception 
    {
        Optional<Card> cards = repo.findById(card.getTitle());
         
        if(cards.isPresent()) 
        {
            Card newEntity = cards.get();
            newEntity.setTitle(card.getTitle());
            newEntity.setDescription(card.getDescription());
            newEntity.setState(card.getState());
 
            newEntity = repo.save(newEntity);
             
            return newEntity;
        } else {
            card = repo.save(card);
             
            return card
            		;
        }
    } 
     
    public void deleteCardByTitle(String title) throws Exception 
    {
        Optional<Card> cards = repo.findById(title);
         
        if(cards.isPresent()) 
        {
            repo.deleteById(title);
        } else {
            throw new Exception("No card record exist for given id");
        }
    } 
}

