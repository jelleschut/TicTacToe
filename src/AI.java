import java.util.ArrayList;
import java.util.Random;

public class AI extends Player {
    private Board board;

    AI(Piece piece, Board board){
        super(piece);
        this.board = board;
    }

    public int[] tryMove() {
        Random r = new Random();
        ArrayList<int[]> possibleMoves = new ArrayList<>();

        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if(board.getPiece(i,j) == Piece.NONE) {
                    int[] p = {i,j};
                    possibleMoves.add(p);
                }
            }
        }

        return possibleMoves.get(r.nextInt(possibleMoves.size()));
    }
}
