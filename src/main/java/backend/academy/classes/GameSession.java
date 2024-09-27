package backend.academy.classes;

import backend.academy.Main;
import backend.academy.classes.handlers.CollectionManager;
import backend.academy.classes.handlers.OutputManager;

public final class GameSession {

    private static Word word;
    private static int countOfGuessedLetters = 0;
    @SuppressWarnings("checkstyle:magicnumber") private static final Character[] GUESSED_LETTERS = new Character[33];
    private static int indexOfGuessedLetters = 0;
    private static int mistakesCurrent = 0;
    private static int mistakesMax;
    private static HangMan hangMan;
    private static final CollectionManager COLLECTION = new CollectionManager();

    private GameSession() {
    }

    public static void setUp(String file, int level) {
        COLLECTION.initialise(file);
        word = COLLECTION.getRandomWord(level);
    }

    @SuppressWarnings("checkstyle:magicnumber")
    public static void startGame(int level) {
        setUp("src/main/resources/words.csv", level);
        mistakesMax = 9 - (level - 1) * level;
        hangMan = new HangMan();
        Main.startGame();
    }

    @SuppressWarnings("checkstyle:magicnumber")
    public static void addMistake() {
        if (mistakesMax == 3 || (mistakesMax == 7 && (mistakesCurrent == 4 || mistakesCurrent == 6))) {
            hangMan.addMistake();
        }
        hangMan.addMistake();
        mistakesCurrent++;

        OutputManager.wrongLetter(hangMan, mistakesMax - mistakesCurrent);

        if (mistakesCurrent == mistakesMax) {
            endGame(false);
        }
    }

    public static void endGame(boolean isWin) {
        Main.endGame();
        if (isWin) {
            OutputManager.win(word.word(), mistakesMax - mistakesCurrent);
        } else {
            OutputManager.loose(word.word());
        }
    }

    public static void giveHint() {
        OutputManager.showMessage(word.hint());
    }

    public static void finishGame() {
        System.exit(0);
    }

    public static boolean guessLetter(String in) {
        char[] letters = in.toCharArray();
        if (letters.length == 1) {
            char letter = letters[0];
            int guessedLettersNow = word.checkLetter(letter);
            if (guessedLettersNow > 0) {
                GUESSED_LETTERS[indexOfGuessedLetters++] = letter;
                OutputManager.showWord(word.word(), GUESSED_LETTERS);
                countOfGuessedLetters = countOfGuessedLetters + guessedLettersNow;
                if (countOfGuessedLetters == word.numberOfLetters()) {
                    endGame(true);
                }
            } else {
                addMistake();
            }
            return true;
        } else {
            return false;
        }
    }
}