public class Test {
 
    public static void testPlayer() {
   
      Player p = new Player("Joe");
      Deck testDeck = new Deck();
      Card c = testDeck.dealCard();
      p.addCardToHand(c);
      p.showHand();
      if(p.hitOrStay()) {
        p.addCardToHand(testDeck.dealCard());
      }
      p.showHand();
    }
   
   }