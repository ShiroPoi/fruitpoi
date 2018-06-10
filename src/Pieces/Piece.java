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

    private boolean boundCheck(Coordinate coords) {
      return !(coords.x() > board.getMaxCoordX() || coords.x() < board.getLeastCoordX() || coords.y() > board.getMaxCoordY() || coords.y < board.getLeastCoordY()); // returns true if coordinates are legal
    }

    private void clearMoveSquares() {
      moveSquares.clear();
    }

    private void addMoveSquare(Coordinate coords) {
      moveSquares.add(coords);
    }
//TODO CHANGE TO PASS DECK
    public abstract void calculateMoveSquares(List<Coordinate>, List<Coordinate>, Player); // pass friendly position AND enemy moveSquares (so king can't Check himself), and current player

    //public abstract boolean isValidPath(int finalX, int finalY);

    //public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);
}
