public abstract class Player {
    private int score;
    private Piece piece;

    Player(Piece piece) {
        this.piece = piece;
        score = 0;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public Piece getPiece() {
        return piece;
    }

    public abstract int[] tryMove();

    @Override
    public String toString() {
        return "Player " + piece;
    }
}
