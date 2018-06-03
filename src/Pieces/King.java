package Pieces;

import Game.*;

public class King extends Piece{

    Type type;
    public boolean inCheck = false;

    public King(int x, int y, Player player){
        super(x, y, player);
        type = Type.KING;
    }

    public Type getType(){
        return Type.KING;
    }



    public int [][] drawPath(int startX, int startY, int finalX, int finalY){
        int pairs = 0; //kings will never have a path
        int [][] path = new int[2][pairs];

        return path;
    }
}
