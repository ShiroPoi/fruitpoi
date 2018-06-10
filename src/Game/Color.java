package Game;

public enum Color{
    RED(0,-1), //BLACK is at bottom of board and moves first in normal shogi
    BLACK(0, 1);

    private final Coordinate moveDir;

    private Color(int x, int y) {
      moveDir = new Coordinate(x,y);
    }

    public Coordinate getMoveDir() {
      return moveDir;
    }
}
