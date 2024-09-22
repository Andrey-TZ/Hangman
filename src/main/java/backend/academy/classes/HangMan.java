package backend.academy.classes;

import lombok.Getter;

public final class HangMan {
    @SuppressWarnings("checkstyle:multiplestringliterals") private final String[] steps =
        {"|    | ", "|    | ", "|    O ", "|    | ", "|   /| ", "|   /|\\", "|    | ", "|   /  ", "|   / \\"};

    @SuppressWarnings("all") @Getter private final String[] hangman = {
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

    @SuppressWarnings("checkstyle:magicnumber")
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

    @SuppressWarnings("checkstyle:magicnumber")
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            out.append(hangman[i]).append('\n');
        }
        return out.toString();
    }

}
