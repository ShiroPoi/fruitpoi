package Pieces;

import Game.*;

public class Gold extends Piece{

    Type type;

    public Gold(int x, int y, Player player){
        super(x,y,player);
        type = Type.GOLD;
    }

    public Type getType(){
        return Type.GOLD;
    }

    public boolean isValidPath(int finalX, int finalY){
        int xDiff = Math.abs(finalX - this.x);
        int yDiff = Math.abs(finalY - this.y);
        if (finalX - this.x == -1 && yDiff == 1) return false;
        else if (xDiff <= 1 && yDiff <= 1 && (xDiff != 0 || yDiff != 0)) return true;
        return false;
    }

    public int[][] drawPath(int startX, int startY, int finalX, int finalY) {
        int pairs = 0;
        int[][] path = new int[2][pairs];

        return path;
    }
}
