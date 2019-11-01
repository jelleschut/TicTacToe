import game.Human;
import game.Piece;
import game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testIncreaseScore() {
        Player p = new Human(Piece.X);
        p.increaseScore();
        p.increaseScore();
        p.increaseScore();

        int expected = 3;
        int actual = p.getScore();

        assertEquals(expected, actual);
    }
}