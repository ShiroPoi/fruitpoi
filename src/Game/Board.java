package Game;
import java.util.List;
import java.util.ArrayList;

/*
our board will have the bottom left corner as 0,0 and top right corner as 8,8, creating a 9x9 board
*/

public abstract class Board {

   private int leastCoordX;
   private int maxCoordX;
   private int leastCoordY;
   private int maxCoordY;

   public Board(int lCX, int mCX, int lCY, int mCY, Piece[][] newPieces, Player[] players) {

     for(int i = 0; i < players.length; i++) {
       List<Piece> delegation = new ArrayList<Piece>();

       for(int j = 0; j < newPieces[i].length; j++)) {
         delegation.add(newPieces[i][j]);
       }

       players[i].assignCurrentDeck(new Deck(delegation));
       players[i].assignHoldingDeck(new Deck());
     }

     leastCoordX = lCX;
     maxCoordX = mCX;
     leastCoordY = lCY;
     maxCoordY = mCY;
   }

   //TODO everything below here

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
   public void newGame() {
      deck.shuffle();
      dealMyCards();
   }

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
   public int size() {
      return cards.length;
   }

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
   public boolean isEmpty() {
      for (int k = 0; k < cards.length; k++) {
         if (cards[k] != null) {
            return false;
         }
      }
      return true;
   }

	public int getMaxCoordX() { return maxCoordX; }
  public int getMaxCoordY() { return maxCoordY; }
  public int getLeastCoordX() { return leastCoordX; }
  public int getLeastCoordY() { return leastCoordY; }

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
   public int deckSize() {
      return deck.size();
   }

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
   public Card cardAt(int k) {
      return cards[k];
   }

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
   public void replaceSelectedCards(List<Integer> selectedCards) {
      for (Integer k : selectedCards) {
         deal(k.intValue());
      }
   }

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 *
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */
   public List<Integer> cardIndexes() {
      List<Integer> selected = new ArrayList<Integer>();
      for (int k = 0; k < cards.length; k++) {
         if (cards[k] != null) {
            selected.add(new Integer(k));
         }
      }
      return selected;
   }

	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
   public String toString() {
      String s = "";
      for (int k = 0; k < cards.length; k++) {
         s = s + k + ": " + cards[k] + "\n";
      }
      return s;
   }

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
   public boolean gameIsWon() {
      if (deck.isEmpty()) {
         for (Card c : cards) {
            if (c != null) {
               return false;
            }
         }
         return true;
      }
      return false;
   }

	/**
	 * Method to be completed by the concrete class that determines
	 * if the selected cards form a valid group for removal.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
   public abstract boolean isLegal(List<Integer> selectedCards);

	/**
	 * Method to be completed by the concrete class that determines
	 * if there are any legal plays left on the board.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
   public abstract boolean anotherPlayIsPossible();

	/**
	 * Deal cards to this board to start the game.
	 */
   private void dealMyCards() {
      for (int k = 0; k < cards.length; k++) {
         cards[k] = deck.deal();
      }
   }
}
