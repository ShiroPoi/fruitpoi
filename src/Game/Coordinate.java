package Game;

public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public void changeCoords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Coordinate coords) {
    return (this.x == coords.x && this.y == coords.y);
  }

  @Override
  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }
}
