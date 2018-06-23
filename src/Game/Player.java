package Game;

public class Player {
    private Color color;
    private String name;
    private Coordinate moveDir;
    private Deck currentDeck;
    private Deck holdingDeck;

    public Player(String name, Color color) {
      this.name = name;
      this.color = color;
      this.moveDir = color.getMoveDir();
    }

    public void assignCurrentDeck(Deck newDeck) { // doubles as initial deck as well as future edits to deck
      this.currentDeck = newDeck;
    }

    public void assignHoldingDeck(Deck newDeck) {
      this.holdingDeck = newDeck;
    }

    public Deck getCurrentDeck() {
      return currentDeck;
    }

    publid Deck getHoldingDeck() {
      return holdingDeck;
    }

    public String getName() {
      return name;
    }

    public Color getColor() {
      return color;
    }

    public Coordinate getMoveDir() {
      return moveDir;
    }

    @Override
    public String toString() {
      return "Player " + name + " is color " + color;
    }
}
