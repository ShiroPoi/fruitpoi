package Pieces;

import Game.*;

public class Rook extends Piece{

    Type type;

    public Rook(int x, int y, Player player){
        super(x, y, player);
        type = Type.ROOK;
        promoted = false;
    }

    public Type getType(){
        return Type.ROOK;
    }

    public boolean isValidPath(int finalX, int finalY){
        if (promoted) {
            if (finalX <= 1 && finalY <= 1) return true;
        }
        if((finalX == this.x) || (finalY == this.y)) {
            return true;
        }
        return false;
    }

    public int [][] drawPath(int startX, int startY, int finalX, int finalY){
        int pairs;
        int x_dir = 0, y_dir = 0;
        if(finalX - startX !=0 && startY == finalY){
            pairs = Math.abs(finalX - startX);
            if(finalX - startX < 0)
                x_dir = -1;
            else
                x_dir = 1;
        }

        else{
            pairs = Math.abs(finalY - startY);
            if(finalY - startY < 0)
                y_dir = -1;
            else
                y_dir = 1;
        }

        int [][] path = new int[2][pairs];
        if(pairs - 1 > 0){
            for(int i = 0; i < pairs - 1; i++){
                path[0][i] = startX + x_dir*1;
                path[1][i] = startY + y_dir*1;
            }
        }

        return path;
    }
}
