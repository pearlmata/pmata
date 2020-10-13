# pmata
API to facilitate the saving and loading of “cards” for a Simple Trello knockoff using Java is built
Written in Java 8 using Spring Boot using an embedded Tomcat server.
Used Spring Data JPA to connect to the in-memory database using H2
CardController manages the Card entities thereby listing possible card states.
Cards have 3 states
TODO
IN-PROGRESS
FINISHED
A single card captures 
Title
Description
State
API performs CRUD operations on the cards 
