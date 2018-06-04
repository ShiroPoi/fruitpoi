package Game;

public class Coordinate<int, int> {
  private int x;
  private int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void x() {
    return x;
  }

  public void y() {
    return y;
  }

  public void changeCoords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Coordinate coords) {
    return (this.x == coords.x && this.y == coords.y);
  }
}
