import game.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    void testGetYesNo() {
        String data = "\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        View v = new View();

        assertTrue(v.getYesNo("Testquestion"));
    }
}