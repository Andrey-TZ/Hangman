package backend.academy.classes.handlers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class INHandlerTest {
    private InputStream sysInBackup;
    ByteArrayInputStream in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;

        outputStreamCaptor.reset();
        OutputManager.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);

        System.setOut(standardOut);
    }

    @Test
    void requestLevel_Wrong() {
        String expectedOut = "Введите желаемую сложность (1-3):\n" +
            "Нужно ввести цифру от 1 до 3\n" +
            "Введите желаемую сложность (1-3):\n" +
            "Неверное значение - нужно ввести цифру от 1 до 3\n" +
            "Введите желаемую сложность (1-3):";
        String wrongInput = "ф" +
            "\n-1" +
            "\n 1";
        in = new ByteArrayInputStream(wrongInput.getBytes());
        System.setIn(in);

        INHandler.requestLevel();

        Assertions.assertEquals(expectedOut, outputStreamCaptor.toString().trim());

    }
}
