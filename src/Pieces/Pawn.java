package Pieces;

import Game.*;

public class Pawn extends Piece{

    public Pawn(int x, int y, Player player){
        super(x,y,player,Type.PAWN);
    }

    @Override
    public void calculateMoveSquares(Deck friendlyDeck, Deck enemyDeck) {
      clearMoveSquares(); // Clean our lists

      Coordinate moveDir = friendlyDeck.getPlayer().getMoveDir();

      if(promoted) { // move as Gold General if promoted

      } else {
        //see if pawn can move forward
        Coordinate testCoord = new Coordinate(this.Coordinate.x(), this.Coordinate.y() + moveDir.y());
        boolean movePossible = boundCheck(testCoord);
        if(movePossible) { // don't bother checking if the test coordinates are out of bounds
          movePossible = checkMove(testCoord, friendlyDeck);
          movePossible = kingDangerCheck(this.getCoordinates(), testCoord, friendlyDeck, enemyDeck);
          if(movePossible) {
            addMoveSquare(test);
          }
        }
      }
    }



    /*(public boolean isValidPath(int finalX, int finalY){
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        if (promoted && finalX - this.x == -1){
            if (yDiff == 1) return false;
        }
        else if (promoted){
            if (xDiff <= 1 && yDiff <= 1 && (xDiff != 0 || yDiff != 0)) return true;
        }
        else if (xDiff == 0 && yDiff == 1) return true;
        return false;
    }

    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = 0;
        int[][] path = new int[2][pairs];

        return path;*/
    }
}
