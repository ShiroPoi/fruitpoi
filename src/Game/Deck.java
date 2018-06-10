package Game;
import java.util.List;
import java.util.ArrayList;


public class Deck {


	private List<Piece> pieces;

	public Deck(List<Piece> newPieces) { // Pieces on board
		pieces = newPieces;
	}

	public Deck() { // Dead pieces that you own
		pieces = new ArrayList<Piece>();
	}

	public Piece pieceAt(int k) { //iterate through deck
		return pieces.get(k);
	}

	public Piece pieceAt(Coord coord) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).getCoordinates().equals(coord)) {
				return pieces.get(i);
			}
		}

		throw new RuntimeException("Could not find piece at coordinate " + coord.toString());
	}

	public int getDeckValue() {
		int sum = 0;

		for(int i = 0;i < pieces.size();i++) {
			sum += pieces.get(i).getValue();
		}

		return sum;
	}

	public boolean isEmpty() {
		if(pieces.size() == 0)
			return true;
		else
			return false;
	}

	public int getSize() {
		return pieces.size();
	}

	public String deckType() {
		return deckType;
	}
}
