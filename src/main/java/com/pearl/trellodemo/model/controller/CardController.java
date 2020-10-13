package com.pearl.trellodemo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearl.trellodemo.model.Card;
import com.pearl.trellodemo.model.CardService;

@RestController
@RequestMapping("/cards")
public class CardController 
{
    @Autowired
    CardService service;
 
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> list = service.getAllCards();
 
        return new ResponseEntity<List<Card>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable("id") String title) 
                                                    throws Exception {
        Card entity = service.getCardById(title);
 
        return new ResponseEntity<Card>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Card> createOrUpdateEmployee(@RequestBody Card card)
                                                    throws Exception {
        Card updated = service.createOrUpdateCard(card);
        return new ResponseEntity<Card>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeByCard(@PathVariable("id") String title) 
                                                    throws Exception {
        service.deleteCardByTitle(title);
        return HttpStatus.OK;
    }
    
 
}