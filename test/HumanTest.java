import game.Human;
import game.Piece;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testTryMove() {
        Human h = new Human(Piece.X);
        String data = "3\r\n3\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        int[] arr = h.tryMove();
        int[] arr2 = {2,2};

        List<Integer> actual = Arrays.asList(arr[0],arr[1]);
        List<Integer> expected = Arrays.asList(arr2[0], arr2[1]);

        assertEquals(actual, expected);
    }
}