public class MiniMax {
    private Piece playerPiece;
    private Piece[] pieces = {Piece.X, Piece.O};

    MiniMax(Player player) {
        this.playerPiece = player.getPiece();
    }

    private int miniMax(Board board, int depth, boolean isMax) {
        int best = isMax ? -1000 : 1000;
        Piece currentPiece = Piece.NONE;

        if (board.isDraw()) {
            return 0;
        }

        if (board.isWon()) {
            return isMax ? 10 - depth : -10 + depth;
        }

        if (isMax) {
            currentPiece = playerPiece;
        } else {
            for (Piece p : pieces) {
                if (p != playerPiece) {
                    currentPiece = p;
                }
            }
        }

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getPiece(i, j) == Piece.NONE) {
                    board.setPiece(new int[]{i, j}, currentPiece);
                    if (isMax) {
                        best = Math.max(best, miniMax(board, depth + 1, false));
                    } else {
                        best = Math.min(best, miniMax(board, depth + 1, true));
                    }
                    board.unSetPiece(new int[]{i, j});
                }
            }
        }
        return best;
    }

    public int[] getBestMove(Board board) {
        int best = -1000;
        int move = 0;
        int[] bestMove = new int[2];
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getPiece(i, j) == Piece.NONE) {
                    move = miniMax(board, 0, false);

                    if (move > best) {
                        best = move;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }
}
