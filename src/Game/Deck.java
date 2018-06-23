package Game;
import java.util.List;
import java.util.ArrayList;


public class Deck {

  private Player player;
	private List<Piece> pieces;

	public Deck(List<Piece> newPieces) { // Pieces on board
		this.player = newPieces.get(0).getPlayer(); // who owns this deck?
		pieces = newPieces;
	}

	public Deck() { // Dead pieces that you own
		this.player = newPieces.get(0).getPlayer();
		pieces = new ArrayList<Piece>();
	}

	public Player getPlayer() {
		return player;
	}

	public Piece pieceAt(int k) { //iterate through deck
		return pieces.get(k);
	}

	public Piece pieceAt(Coordinate coord) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).getCoordinates().equals(coord)) {
				return pieces.get(i);
			}
		}

		throw new RuntimeException("Could not find piece at coordinate " + coord.toString());
	}

  public void addPiece(Piece newPiece) {
    pieces.add(newPiece);
  }

  public void removePiece(int k) {
    pieces.remove(k);
  }

  public void removePiece(Coordinate coord) {
    for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).getCoordinates().equals(coord)) {
				pieces.remove(i);
			}
		}

		throw new RuntimeException("Could not find piece at coordinate " + coord.toString());
  }

  public Piece getPiece(int k) {
    return pieces.remove(k);
  }

  public Piece getPiece(Coordinate coord) {
    for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).getCoordinates().equals(coord)) {
				return pieces.remove(i);
			}
		}

		throw new RuntimeException("Could not find piece at coordinate " + coord.toString());
  }

  public Coordinate getKingCoord() {
    for(int i = 0; i < pieces.size(); i++) {
      if(pieces.get(i).getType() == Type.KING) {
        return pieces.get(i).getCoordinates();
      }
    }
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
