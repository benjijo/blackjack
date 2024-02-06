import java.util.ArrayList;

public class Deck {
//Instance variables
ArrayList<String> suits = new ArrayList<String>();
ArrayList<String>names = new ArrayList<String>();
ArrayList<Integer>values = new ArrayList<Integer>();

//Structure to hold deck
ArrayList<Card> gameDeck = new ArrayList<Card>();

//Constructor
public Deck() {
createDeck();
}

//Creating potential suits, names, values of cards
public void createDeck() {
populateSuits();
populateNames();
populateValues();
addCardsToDeck();

}

//Creating one of each card and adding to deck
public void addCardsToDeck() {
  for(int i=0; i < suits.size(); i++){
      for(int j=0; j < names.size(); j++){
          Card temp = new Card(suits.get(i), names.get(j), values.get(j));
          gameDeck.add(temp);
      }
  }
}

public void populateSuits() {
suits.add("Clubs");
suits.add("Hearts");
suits.add("Spades");
suits.add("Diamonds");
}

public void populateNames() {
names.add("Two");
names.add("Three");
names.add("Four");
names.add("Five");
names.add("Six");
names.add("Seven");
names.add("Eight");
names.add("Nine");
names.add("Ten");
names.add("Jack");
names.add("Queen");
names.add("King");
names.add("Ace");

}
public void populateValues() {
for(int i = 2; i < 11;i++) {
  values.add(i);
}
values.add(10);
values.add(10);
values.add(10);
values.add(11);
}

//Clear deck
public void clearDeck(){
    this.gameDeck.clear();
}


//Test method for printing out whole deck
public void printDeck() {
System.out.println("The deck contains " + gameDeck.size() + " cards");
for(int index = 0; index < gameDeck.size(); index++) {
  Card temp = gameDeck.get(index);
  System.out.println(temp);
}
}


//Selecting random card from remaining cards in deck and returning that card
public Card dealCard() {
    int randomPos = (int)(Math.random() * (gameDeck.size()));
    return gameDeck.remove(randomPos);
}
}