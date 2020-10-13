package com.pearl.trellodemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	public String  title;
	public String description;
	public String state;
	
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(String title, String description, String state) {
		super();
		this.title = title;
		this.description = description;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Card [title=" + title + ", description=" + description + ", state=" + state + "]";
	}
	

}
