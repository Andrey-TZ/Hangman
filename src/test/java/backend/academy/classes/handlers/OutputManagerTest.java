package backend.academy.classes.handlers;

import backend.academy.classes.HangMan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class OutputManagerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        outputStreamCaptor.reset();
        OutputManager.setOut(new PrintStream(outputStreamCaptor));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void showWord_doubleLetters() {
        String word = "тест";
        Set<Character> guessedLetters = new HashSet<>();
        guessedLetters.add('т');

        OutputManager.showWord(word, guessedLetters);

        Assertions.assertEquals("т__т", outputStreamCaptor.toString().trim());
    }

    @Test
    void showHangMan() {
        HangMan hangMan = new HangMan();
        hangMan.addMistake();
        hangMan.addMistake();
        hangMan.addMistake();
        int tries = 6;
        String expectedOut =
            hangMan.toString() + "Попыток осталось: 6";

        OutputManager.showHangMan(hangMan, tries);

        Assertions.assertEquals(expectedOut, outputStreamCaptor.toString().trim());
    }

}
