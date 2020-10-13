package com.pearl.trellodemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pearl.trellodemo.dao.CardRepo;
import com.pearl.trellodemo.model.Card;

@RunWith(SpringRunner.class)
	@SpringBootTest
	public class RepoTest {

	  @Autowired
	  private CardRepo repository;
	  
	  @Test
	  public void getCardTest() {
		  Card card = new Card("lunch","team lunch", "finished");
		  repository.findById("lunch");
		  assertEquals(card.getTitle(),"lunch");
		  
	  }
	  @Test
	  public void createOrUpdateCardTest() {
	    Card card = new Card("scrum","scrum meeting","finished");
	    repository.save(card);
	    assertEquals(card.getTitle(),"scrum");
	  
	}  
	  @Test
	  public void deleteCardTest() {
		Optional <Card>card = Optional.ofNullable(new Card("scrum","scrum meeting","finished"));
		  repository.deleteById("scrum");
		  assertTrue(card.isPresent());
	  }
}
