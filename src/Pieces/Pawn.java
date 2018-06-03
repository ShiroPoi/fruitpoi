package Pieces;

import Game.*;

public class Pawn extends Piece {

    Type type;

    public Pawn(int x, int y){
        super(x,y,player);
        type = Type.PAWN;
    }

    public Type getType() {return Type.PAWN;}

    public boolean isValidPath(int finalX, int finalY){
        int yDiff = Math.abs(finalY - this.y);
        if (finalX == x && yDiff == 1) return true;
        else return false;
    }

    public int[][] drawPath(int startX, int startY, int finalX, int finalY){
        int [][] path = new int [2][1];
        path[0][0] = startX;
        path[1][0] = startY + 1;
        return path;
    }
}