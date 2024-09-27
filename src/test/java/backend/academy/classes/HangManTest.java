package backend.academy.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HangManTest {
    private HangMan hangMan;

    @BeforeEach
    void setUp() {
        hangMan = new HangMan();
    }

    @Test
    void addMistake_oneMistake() {
        String hangManExpected = "______ \n|    | \n|      \n|      \n|      \n|      \n|      \n|      \n|_______\n";

        hangMan.addMistake();

        Assertions.assertEquals(hangMan.toString(), hangManExpected);
    }

    @Test
    void addMistake_maxMistakes() {
        String hangManExpected = "______ \n|    | \n|    | \n|    O \n|   /|\\\n|    | \n|   / \\\n|      \n|_______\n";

        for (int i = 0; i < 9; i++) {
            hangMan.addMistake();
        }

        Assertions.assertEquals(hangMan.toString(), hangManExpected);
    }

}
