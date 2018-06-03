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
        if (promoted){
            if (finalX <= 1 && finalY <= 1 && (xDiff != 0 || yDiff != 0)) return true;
        }
        else if (finalX == x && yDiff == 1) return true;
        return false;
    }

    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = 0;
        int[][] path = new int[2][pairs];

        return path;
    }
}