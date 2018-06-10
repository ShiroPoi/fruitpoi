package Game;
import java.util.List;
import java.util.ArrayList;

/**
 * The ShogiBoard class represents the board in a game of Shogi.
 */
public class ShogiBoard extends Board {

  //9x9 board bottom left 0,0 and top right 8,8
  private static final int leastCoordX = 0;
  private static final int maxCoordX = 8;
  private static final int leastCoordY = 0;
  private static final int maxCoordY = 8;

  private Piece[][] initialPieces;

   public ShogiBoard(Player[] players) { // ideally only 2 players
     initialPieces = new Piece[2][20];

     //setting up pieces in Itou order
     //first is king
     initialPieces[0][0] = new Piece(4, 0, Type.KING, players[0]); //first player
     initialPieces[1][0] = new Piece(4, 8, Type.KING, players[1]); //second player

     //next are gold generals
     initialPieces[0][1] = new Piece(3, 0, Type.GOLD, players[0]);
     initialPieces[1][1] = new Piece(5, 8, Type.GOLD, players[1]);
     initialPieces[0][2] = new Piece(5, 0, Type.GOLD, players[0]);
     initialPieces[1][2] = new Piece(3, 8, Type.GOLD, players[1]);

     //next are silver generals
     initialPieces[0][3] = new Piece(2, 0, Type.SILVER, players[0]);
     initialPieces[1][3] = new Piece(6, 8, Type.SILVER, players[1]);
     initialPieces[0][4] = new Piece(6, 0, Type.SILVER, players[0]);
     initialPieces[1][4] = new Piece(2, 8, Type.SILVER, players[1]);

     //next are knights
     initialPieces[0][5] = new Piece(1, 0, Type.KNIGHT, players[0]);
     initialPieces[1][5] = new Piece(7, 8, Type.KNIGHT, players[1]);
     initialPieces[0][6] = new Piece(7, 0, Type.KNIGHT, players[0]);
     initialPieces[1][6] = new Piece(1, 8, Type.KNIGHT, players[1]);

     //next are pawns
     for(int i = leastCoordX; i < maxCoordX; i++) { // doing pawns
       initialPieces[0][i+7] = new Piece(i, 2, Type.PAWN, players[0]);
       initialPieces[1][i+7] = new Piece(8-i, 6, Type.PAWN, players[1]);
     }

     //next are lances
     initialPieces[0][16] = new Piece(0, 0, Type.LANCE, players[0]);
     initialPieces[1][16] = new Piece(0, 8, Type.LANCE, players[1]);
     initialPieces[0][17] = new Piece(8, 0, Type.LANCE, players[0]);
     initialPieces[1][17] = new Piece(8, 8, Type.LANCE, players[1]);

     //next are bishop
     initialPieces[0][18] = new Piece(1, 1, Type.BISHOP, players[0]);
     initialPieces[1][18] = new Piece(7, 7, Type.BISHOP, players[1]);

     //next are rooks
     initialPieces[0][19] = new Piece(7, 1, Type.ROOK, players[0]);
     initialPieces[1][19] = new Piece(1, 7, Type.ROOK, players[1]);

     super(leastCoordX, maxCoordX, leastCoordY, maxCoordY, initialPieces, players);
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
