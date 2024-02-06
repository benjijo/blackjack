import java.util.ArrayList;

public class Dealer {
  //Instance variables
  ArrayList<Card> hand = new ArrayList<Card>();
  int total = 0;
  String name = "Dealer";
 
  //Constructor
  public Dealer() {
    
  }
 
 //Getters
  public int getTotal(){
      return this.total;
  }
  
  //Clearing hand for new game
  public void clearHand(){
      this.hand.clear();
  }
  

  //Adding card
  public void addCardToHand(Card c) {
    this.hand.add(c);
    this.calculateTotal();
    
  } 

  //Only printing the first card
  public void showFirstCard() {
    System.out.println("Dealer's First Card:");
    System.out.println();
    System.out.println(hand.get(0));
  }

  //Printing all cards after player is done
  public void revealCards() {
    System.out.println("Dealer Hand:");
    System.out.println();
    for(int i = 0; i < hand.size(); i++){
        System.out.println(hand.get(i));
    }
  }

 
 //Calculating total value of cards in hand
 public void calculateTotal() {
    this.total = 0;
    for(int i = 0; i < hand.size(); i++){
        this.total = this.total + (hand.get(i)).getValue();
    }
    
    //Checking if possible combinations are possible by changing Aces to 1
    if(this.total > 21){
        this.total = 0;
        for(int i = 0; i < hand.size(); i++){
            if((hand.get(i)).getValue() == 11){
                (hand.get(i)).changeAce();
            }
            this.total = this.total + (hand.get(i)).getValue();
        }
    }
  }
}