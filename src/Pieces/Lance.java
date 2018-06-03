package Pieces;

import Game.*;

public class Lance extends Piece{

    Type type;

    public Lance(int x, int y, Player player){
        super(x, y, player);
        type = Type.LANCE;
    }

    public Type getType(){
        return type.LANCE;
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
        else if ((xDiff == 0) && (finalY - this.y > 0)){
            return true;
        }
        return false;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY){
        int pairs;
        pairs = finalY - startY;

        int [][] path = new int[2][pairs];
        if(pairs - 1 > 0)
        {
            for(int i = 0; i < pairs - 1; i++)
            {
                path[0][i] = startX;
                path[1][i] = startY + i;
            }
        }

        return path;
    }
}