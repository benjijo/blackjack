public class Card {
    //Instance Variables
    String suit;
    String name;
    int value;
  
    //Constructors
    public Card(String s, String nm, int val) {
      this.suit = s;
      this.name = nm;
      this.value = val;
    }
  
    //Setters & Getters
    public String getSuit(){
        return this.suit;
    }
    
    //Getters
    public String getName(){
        return this.name;
    }
    
    public int getValue(){
        return this.value;
    }
    
    //Changing Ace to 1
    public void changeAce(){
        if(this.value == 11){
            this.value = 1;
        }
    }
  
    //Printing useful values
    public String toString() {
      return "Suit: " + suit + " Name: " + name + " Value: " + value + "\n";
    }
  }