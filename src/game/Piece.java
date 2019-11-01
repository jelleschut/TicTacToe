package game;

public enum Piece {
    X("X"),
    O("O"),
    NONE("_");

    private String piece;

    Piece(String piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return piece;
    }
}
