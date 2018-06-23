package Pieces;

import Game.*;

public abstract class Piece {

    private Coordinate coordinates;
    private Player player;
    private List<Coordinate> moveSqaures;
    private Type type;
    private boolean promoted;
    private int value;

    public Piece(int x, int y, Type type, Player player) {
        this.coordinates = new Coordinate(x, y);
        this.player = player;
        this.type = type;
        this.promoted = false;
        this.moveSqaures = new ArrayList<Coordinate>();
    }

    public Piece(Coordinate coords, Type type, Player player) {
        this.coordinates = coords;
        this.player = player;
        this.type = type;
        this.promoted = false;
        this.moveSqaures = new ArrayList<Coordinate>();
    }

    public int getValue() {
      if(promoted)
        return this.type.getPromotedValue();
      else
        return this.type.getValue();
    }

    public Type getType() {
      return type;
    }

    public Player getPlayer() {
      return player;
    }

    public void changePlayer(Player newPlayer) {
      this.player.Color = newPlayer.Color;
    }

    public void movePiece(Coordinate coords) {
      this.coordinates = coords;
    }

    public Coordinate getCoordinates() {
      return coordinates;
    }

    public boolean getPromoted() {
      return promoted;
    }

    public void promotePiece() {
      promoted = true;
      value = assignValue();
    }

    public void demotePiece() {
      promoted = false;
      value = assignValue();
    }

    public List<Coordinate> getMoveSquares() {
      return moveSqaures;
    }

    private void clearMoveSquares() {
      moveSquares.clear();
    }

    private void addMoveSquare(Coordinate coords) {
      moveSquares.add(coords);
    }

    public abstract void calculateMoveSquares(Deck friendlyDeck, Deck enemyDeck);

    private boolean boundCheck(Coordinate coords) {
      return !(coords.x() > board.getMaxCoordX() || coords.x() < board.getLeastCoordX() || coords.y() > board.getMaxCoordY() || coords.y < board.getLeastCoordY()); // returns true if coordinates are legal
    }


    private boolean checkMove(Coordinate coords, Deck friendlyDeck) {
      for(int i = 0; i < friendlyDeck.getSize(); i++) {
        if(coords.equals(friendlyDeck.pieceAt(i).getCoordinates())) {
          return false;
        }
      }

      return true;
    }

    private boolean kingDangerCheck(Coordinate movingPieceCoords, Coordinate newCoords, Deck friendlyDeck, Deck enemyDeck) {
        Piece testingPiece = friendlyDeck.getPiece(movingPieceCoords);
        testingPiece.movePiece(newCoords);
        friendlyDeck.removePiece(movingPieceCoords);
        friendlyDeck.addPiece(testingPiece);

        calculateMoveSquares(enemyDeck,friendlyDeck);
        for(Piece p : enemyDeck) {
          if(p.getMoveSqaures().contains(friendlyDeck.getKingCoord())) {
            return true;
          }
        }

        return false;
    }


    //public abstract boolean isValidPath(int finalX, int finalY);

    //public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);
}
