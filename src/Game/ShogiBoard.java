import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
   private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
   private static final String[] RANKS =
   	{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
   private static final String[] SUITS =
   	{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
   private static final int[] POINT_VALUES =
   	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
   private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
   public ElevensBoard() {
      super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
   }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
   @Override
   public boolean isLegal(List<Integer> selectedCards) {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
      
      /******** Cossa's pseudocode:
      1. Find out how many values are in selectedCard
      2. Based on #1 send selectedCard ArrayList to appropriate helper methods
      3. Based on what methods invoked in #2 return, have this method return
         correct boolean value
      ***************************************/ 
	  if(selectedCards.size() == 2)
	  {
		  return containsPairSum11(selectedCards);
	  }
	  else if(selectedCards.size() == 3)
	  {
		  return containsJQK(selectedCards);
	  }
	  else
		  return false;
   }

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
   @Override
   public boolean anotherPlayIsPossible() {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
       
       /******** Cossa's pseudocode:
       ***You need to look at all the cards on the board
          and see if there is another play possible***
      1. Get the indexes of all cards on the board (look at other methods to help with this)
      2. Send the values from #1 to appropriate helper methods
      3. Based on what methods invoked in #2 return, have this method return
         correct boolean value
      ***************************************/ 
	   
	   if(containsPairSum11(cardIndexes()) == true || containsJQK(cardIndexes()) == true)
	   {
		   return true;
	   }
	   else
		   return false;
   }

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
   private boolean containsPairSum11(List<Integer> selectedCards) {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
       
       /******** Cossa's pseudocode:
       ***Remember the selectedCard ArrayList could have more than 2 values
          because sometimes this method is executed with all of the 
          cards left on the board and sometimes it is executed with only 
          the 2 cards the user selected. Therefore you need to compare
          all of the cards in the list against each other*** 
      1. Create nested loops to traverse the list
      2. Each time the outside loops starts, get the Card at that index
      3. Each time the inside loop begins, get the Card at that index, 
         see if it and the other card add up to 11. (The inside loop will 
         compare all cards against the card from the outside loop).
      4. Determine where and how to return the correct boolean value 
      ***************************************/ 
	   /*
	  for(int temp : selectedCards)
	  {
		  System.out.println(temp);
	  }
	  debug
	  */
	   
      for(int i = 0;i<selectedCards.size()-1;i++)
      {
    	  for(int j = i;j<selectedCards.size()-1;j++)
    	  {
    		  // debug System.out.println(cardAt(selectedCards.get(i)).pointValue() + " " + cardAt(selectedCards.get(j+1)).pointValue());
	    	  if(cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j+1)).pointValue() == 11)
	    	  {
	    		  // debug  System.out.println("11 T");
	    		  return true;
	    	  }
    	  }
      }

      // debug System.out.println("11 F");
      return false;
   }

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
   private boolean containsJQK(List<Integer> selectedCards) {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
      
      /******** Cossa's pseudocode:
       ***Remember the selectedCard ArrayList could have more than 3 values
          because sometimes this method is executed with all of the 
          cards left on the board and sometimes it is executed with only 
          the 3 cards the user selected. Therefore you need to compare
          all of the cards in the list against each other*** 
      1. Create a loop to traverse the list
      2. Each time the loops starts, get the Card at that index
      3. Check to see if that card is a J, Q or K
      4. Determine how to keep track of whether or not a 
         J, Q, and K were found and return the correct boolean value 
      ***************************************/ 
	   boolean J = false, Q = false, K = false;
	  for(int temp : selectedCards)
	  {
		  // debug System.out.println(temp);
		  if(cardAt(temp).rank().equals("jack"))
		  {
			  J = true;
		  }
		  else if(cardAt(temp).rank().equals("queen"))
		  {
			  Q = true;
		  }
		  else if(cardAt(temp).rank().equals("king"))
		  {
			  K = true;
		  }
	  }
	  if(J == true && Q == true && K == true)
	  {
		  //  debug System.out.println("JQK t");
		  return true;
	  }
	  else
	  {
		  // debug System.out.println("JQK f");
		  return false;
	  }
	  
   }
}
