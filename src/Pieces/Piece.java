package Pieces;

import Game.*;

public abstract class Piece {

    public int x,y;
    public Player player;
    boolean promoted;

    public Piece(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public abstract Type getType();

    public abstract boolean isValidPath(int finalX, int finalY);

    public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);
}

