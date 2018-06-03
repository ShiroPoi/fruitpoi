package Pieces;

import Game.*;

public class Pawn extends Piece{

    Type type;

    public Pawn(int x, int y, Player player){
        super(x,y,player);
        type = Type.PAWN;
        promoted = false;
    }

    public Type getType(){
        return Type.PAWN;
    }

    public boolean isValidPath(int finalX, int finalY){
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

        return path;
    }
}