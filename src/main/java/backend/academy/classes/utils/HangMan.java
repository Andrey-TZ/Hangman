package backend.academy.classes.utils;

import lombok.Getter;
import lombok.ToString;

public class HangMan {
    private final String[] steps =
        {"|    | ", "|    | ", "|    O ", "|    | ", "|   /| ", "|   /|\\", "|    | ", "|   /  ", "|   / \\"};
    private final String[] hangman_final = {
        "______ ",
        "|    | ",
        "|    | ",
        "|    O ",
        "|   /|\\",
        "|    | ",
        "|   / \\",
        "|      ",
        "|_______"
    };
    @Getter private final String[] hangman = {
        "______ ",
        "|      ",
        "|      ",
        "|      ",
        "|      ",
        "|      ",
        "|      ",
        "|      ",
        "|_______"
    };
    private int mistakes = 0;

    public void addMistake() {
        if (mistakes == 8) {
            hangman[6] = steps[mistakes];
        } else if (mistakes >= 5) {
            hangman[mistakes - 1] = steps[mistakes];
        } else if (mistakes == 4) {
            hangman[mistakes] = steps[mistakes];
        } else {
            hangman[mistakes + 1] = steps[mistakes];
        }
        mistakes++;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            out.append(hangman[i]);
            out.append("\n");
        }
        return out.toString();
    }

}
