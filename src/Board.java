public class Board {
    private int size;
    private Piece[][] board;

    Board(int size) {
        this.size = size;
        board = new Piece[size][size];
        clear();
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Piece.NONE;
            }
        }
    }

    private boolean isAvailable(int[] coordinates) {
        return board[coordinates[0]][coordinates[1]] == Piece.NONE;
    }

    private boolean isInBounds(int[] coordinates) {
        return ((0 <= coordinates[0] && coordinates[0] < size) && (0 <= coordinates[1] && coordinates[1] < size));
    }

    public boolean isDraw() {
        for (Piece[] arr : board) {
            for (Piece p : arr) {
                if (p == Piece.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon() {
        for (int i = 0; i < size; i++) {
            Piece tempHorizontal = board[0][i];
            Piece tempVertical = board[i][0];

            for (int j = 1; j < size && board[i][j] != Piece.NONE; j++) {
                if (board[i][j] != tempVertical) {
                    break;
                }
                if (j == size - 1) {
                    return true;
                }
            }

            for (int j = 1; j < size && board[j][i] != Piece.NONE; j++) {
                if (board[j][i] != tempHorizontal) {
                    break;
                }

                if (j == size - 1) {
                    return true;
                }
            }
        }

        for (int i = 0; i < size - 1 && board[i][i] != Piece.NONE; i++) {
            if (board[i + 1][i + 1] != board[0][0]) {
                break;
            }
            if (i == size - 1 - 1) {
                return true;
            }
        }

        for (int i = 0; i < size - 1 && board[i][i] != Piece.NONE; i++) {
            if (board[i + 1][size - 1 - i - 1] != board[0][size - 1]) {
                break;
            }
            if (i == size - 1 - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean setPiece(int[] coordinates, Piece piece) {
        if (isInBounds(coordinates)) {
            if (isAvailable(coordinates)) {
                board[coordinates[0]][coordinates[1]] = piece;
                return true;
            }
        }
        return false;
    }

    public void unSetPiece(int[] coordinates) {
        if (isInBounds(coordinates)) {
            board[coordinates[0]][coordinates[1]] = Piece.NONE;
        }
    }

    public int getSize() {
        return size;
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public Piece[][] getBoard() {
        return board;
    }
}
