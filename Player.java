//Arraylist and scanner methods
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  //Instance variables
  Scanner scan = new Scanner(System.in);
  ArrayList<Card> hand = new ArrayList<Card>();
  int total;
  String name;
 
  //Constructor
  public Player(String nm) {
    name = nm;
  }
  
  //Getters
  public int getTotal(){
      return this.total;
  }
  
  //Clear hand (for new game)
  public void clearHand(){
      this.hand.clear();
  }
 

  //Asking if player wants to hit or stay
  public boolean hitOrStay() {
    boolean decision = false;
    String input;
    int count = 0;
    
    System.out.println("Would you like to hit or stay?");
    input = scan.nextLine();
    
    //If user input is invalid code will restart until valid
    while(count == 0){
        if(input.equals("hit")){
            decision = true;
            count++;
        }
        else if(input.equals("stay")){
            decision = false;
            count++;
        }
        else{
            System.out.println("Please type 'hit' or 'stay'.");
            input = scan.nextLine();
            System.out.println(" ");
        }
    }

    return decision;
  }

  //Adding card to hand
  public void addCardToHand(Card c) {
    this.hand.add(c);
    this.calculateTotal();
  } 

  //Printing toString for every card in player hand
  public void showHand() {
    System.out.println("Player Hand:");
    System.out.println();
    for(int i = 0; i < hand.size(); i++){
        System.out.println(hand.get(i));
    }

  }

  //Calculating total value of cards
  public void calculateTotal() {
    this.total = 0;
    for(int i = 0; i < hand.size(); i++){
        this.total = this.total + (hand.get(i)).getValue();
    }
    
    //Checking if possible combination is possible
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

  //Checking if player wants to play again
  public boolean continueGame() {
    System.out.println(" ");
    System.out.println("Would you like to play again? (Y/N)");
    String input = scan.nextLine();
    
    //Keeps iterating until either Y or N is received
    while(input != "Y" && input != "N"){
        if(input.equals("Y")){
            return true;
        }
        else if(input.equals("N")){
            return false;
        }
        else{
            System.out.println("Please type 'Y' or 'N'.");
            input = scan.nextLine();
            System.out.println(" ");
        }
    }
    return false;
  }


}