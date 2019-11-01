import game.Board;
import game.InvalidMoveException;
import game.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testSetPiece() throws InvalidMoveException {
        Board board = new Board(3);

        assertTrue(board.setPiece(new int[]{2,2}, Piece.X));
    }
}