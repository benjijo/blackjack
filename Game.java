public class Game {
    //Instance Variables
    Player playerOne;
    Dealer dealerOne;
    Deck gameDeck;
    
    //Constructor
    public Game() {
      playerOne = new Player("Benji");
      dealerOne = new Dealer();
      gameDeck = new Deck();
    }
    //Main game loop
    public void play() {
    
      //Creating deck and dealing cards
      gameDeck.createDeck();
      dealTwoCards();
      
      //Start game by showing dealer 1st card
      dealerOne.showFirstCard();
      
      //Show player cards
      updatePlayerHand();
    
      //Player hit or stay, updating player hand depending on outcome
      while(playerOne.getTotal() < 21){
          if(playerOne.getTotal() == 21){
              System.out.println(" ");
              System.out.println("Blackjack");
              break;
          }
          if(playerOne.hitOrStay() == true){
              System.out.println(" ");
              playerOne.addCardToHand(gameDeck.dealCard());
              updatePlayerHand();
          }
          else{
              System.out.println(" ");
              break;
          }
      }
    
      //Updating dealer hand until greater than 17
      dealerOne.calculateTotal();
      while(dealerOne.getTotal() < 17){
          dealerOne.addCardToHand(gameDeck.dealCard());
      }
      
      dealerOne.revealCards();
          System.out.println("Dealer's total is " + dealerOne.total + ".");
        System.out.println(" ");
    
      //Determining winner for all outcomes
      if(playerOne.getTotal() > dealerOne.getTotal()){
          if(checkPlayerBust() == true){
              System.out.println("You win!");
          }
          else{
              if(checkDealerBust() == true){
                  System.out.println("Dealer wins!");
              }
              else{
                  System.out.println("Both bust!");
              }
          }
      }
      if(playerOne.getTotal() < dealerOne.getTotal()){
          if(checkDealerBust() == true){
              System.out.println("Dealer wins!");
          }
          else{
              if(checkPlayerBust() == true){
                  System.out.println("Player wins!");
              }
              else{
                  System.out.println("Both bust!");
              }
          }
      }
      if(playerOne.getTotal() == dealerOne.getTotal()){
          if(checkPlayerBust() == true || checkDealerBust() == true){
              System.out.println("Tie!");
          }
          else{
              System.out.println("Both bust!");
          }
      }
    
      //Check for replay
      if(playerOne.continueGame() == true){
          resetGame();
      }
      else{
          System.out.println("Thanks for playing!");
      }
    
    
    }
      
    //Starting both player and dealer with a two card hand
    public void dealTwoCards(){
        playerOne.addCardToHand(gameDeck.dealCard());
        playerOne.addCardToHand(gameDeck.dealCard());
        dealerOne.addCardToHand(gameDeck.dealCard());
        dealerOne.addCardToHand(gameDeck.dealCard());
    }
    
    //Resetting player hand, dealer hand, and deck, clearing out text, reiterating game loop
    public void resetGame(){
          gameDeck.clearDeck();
          playerOne.clearHand();
          dealerOne.clearHand();
          for(int i = 0; i < 100; i++){
              System.out.println(" ");
          }
          this.play();
    }
    
    //Reading all cards in player hand and printing out the total value
    public void updatePlayerHand(){
      playerOne.showHand();
      System.out.println("Your total is " + playerOne.getTotal() + ".");
      System.out.println(" ");
    }
    
    //Checking if player or dealer has gone over 21
    public boolean checkPlayerBust(){
        if(playerOne.getTotal() > 21){
            return false;
        }
        return true;
    }
    
    public boolean checkDealerBust(){
        if(dealerOne.getTotal() > 21){
            return false;
        }
        return true;
    }
    }