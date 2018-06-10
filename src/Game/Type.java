package Game;

public enum Type {
    PAWN(1, 7),
    LANCE(3, 6),
    KNIGHT(4, 6),
    SILVER(5, 6),
    GOLD(6, 6),
    BISHOP(8, 10),
    ROOK(10, 12),
    KING(0, 0);

    private final int value;
    private final int promotedValue;

    private Type(int v, int pV) {
      value = v;
      promotedValue = pV;
    }

    public int getValue() {
      return this.value;
    }

    public int getPromotedValue() {
      return this.promotedValue;
    }
}
