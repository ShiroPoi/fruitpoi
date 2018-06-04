package Pieces;

import Game.*;

public abstract class Piece {

    private Coordinate coordinates;
    private Player player;
    private List<Coordinate> moveSqaures;
    private Type type;
    private boolean promoted;

    public Piece(int x, int y, Player player, Type type) {
        this.coordinates = new Coordinate(x, y);
        this.player = player;
        this.type = type;
        this.promoted = false;
        this.moveSqaures = new ArrayList<Coordinate>();
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

    public boolean getPromoted() {
      return promoted;
    }

    public void promotePiece() {
      promoted = true;
    }

    public void demotePiece() {
      promoted = false;
    }

    public List<Coordinate> getMoveSquares() {
      return moveSqaures;
    }

    private boolean boundCheck(Coordinate coords) {
      return !(coords.x() > 8 || coords.x() < 0 || coords.y() > 8 || coords.y < 0) // returns true if coordinates are legal
    }

    private void clearMoveSquares() {
      moveSquares.clear();
    }

    private void addMoveSquare(Coordinate coords) {
      moveSquares.add(coords);
    }

    public abstract void calculateMoveSquares(List<Coordinate>, List<Coordinate>, Player); // pass friendly position AND enemy moveSquares (so king can't Check himself), and current player

    //public abstract boolean isValidPath(int finalX, int finalY);

    //public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);
}
