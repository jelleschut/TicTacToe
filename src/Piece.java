public enum Piece {
    X("X"),
    O("O"),
    NONE(" ");

    private String piece;

    Piece(String piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return piece;
    }
}
