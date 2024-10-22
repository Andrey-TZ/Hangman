package backend.academy.classes;

import backend.academy.classes.handlers.OutputManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameSessionTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    GameSession gameSession = new GameSession();

    @BeforeEach
    public void setUp() {
        gameSession.setUp("src/test/resources/test_collection.csv", 1);
        outputStreamCaptor.reset();
        OutputManager.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void giveHint() {
        String hintExpected = "то, что я сейчас пишу";

        gameSession.giveHint();
        String hint = outputStreamCaptor.toString().trim();

        Assertions.assertEquals(hintExpected, hint);
    }

    @Test
    void guessLetter_wrong() {
        Assertions.assertFalse(gameSession.guessLetter("аб"));
    }

    @Test
    void guessLetter_right() {
        String expectedOut = "_е__";

        gameSession.guessLetter("е");
        String out = outputStreamCaptor.toString().trim();

        Assertions.assertEquals(expectedOut, out);
    }
}
