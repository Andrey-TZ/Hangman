package backend.academy.classes;

import backend.academy.classes.handlers.CollectionManager;
import backend.academy.classes.handlers.CommandManager;
import backend.academy.classes.handlers.INHandler;
import backend.academy.classes.handlers.OutputManager;
import java.util.HashSet;
import java.util.Set;

public final class GameSession {

    private static final int LOW_DIFF_MAX_MISTAKES = 9;
    private static final int MED_DIFF_MAX_MISTAKES = 7;
    private static final int HIGH_DIFF_MAX_MISTAKES = 3;
    private static final int ADDITIONAL_MISTAKE_MED_DIFF_1 = 4;
    private static final int ADDITIONAL_MISTAKE_MED_DIFF_2 = 6;
    private static final CollectionManager COLLECTION = new CollectionManager();

    private int guessedLettersCounter = 0;
    private boolean gameStarted = false;
    private boolean gameEnded = false;
    private Word word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int mistakesCurrent = 0;
    private int mistakesMax;
    private HangMan hangMan;

    public void run() {
        String input;
        while (!gameStarted) {
            input = INHandler.requestString("Введите команду:");
            CommandManager.start(input);
        }
        while (!gameEnded) {
            input = INHandler.requestString("Введите букву или команду:");
            if (guessLetter(input)) {
                continue;
            } else if (CommandManager.start(input)) {
                continue;
            }
            OutputManager.showMessage("Введено больше одной буквы");

        }
        finishGame();
    }

    public void setUp(String file, int difficulty) {
        COLLECTION.initialise(file);
        word = COLLECTION.getRandomWord(difficulty);
    }

    public void startGame() {
        int difficulty = INHandler.requestDifficulty();
        setUp("src/main/resources/words.csv", difficulty);
        mistakesMax = LOW_DIFF_MAX_MISTAKES - (difficulty - 1) * difficulty;
        hangMan = new HangMan();
        gameStarted = true;
    }

    public void addMistake() {
        if (mistakesMax == HIGH_DIFF_MAX_MISTAKES
            || (mistakesMax == MED_DIFF_MAX_MISTAKES && (mistakesCurrent == ADDITIONAL_MISTAKE_MED_DIFF_1
            || mistakesCurrent == ADDITIONAL_MISTAKE_MED_DIFF_2))) {
            hangMan.addMistake();
        }
        hangMan.addMistake();
        mistakesCurrent++;

        OutputManager.showHangMan(hangMan, mistakesMax - mistakesCurrent);

        if (mistakesCurrent == mistakesMax) {
            looseGame();
        }
    }

    public void winGame() {
        gameEnded = true;
        OutputManager.win(word.word(), mistakesCurrent);
    }

    public void looseGame() {
        gameEnded = true;
        OutputManager.loose(word.word());
    }

    public void giveHint() {
        OutputManager.showMessage(word.hint());
    }

    public void finishGame() {
        System.exit(0);
    }

    public boolean guessLetter(String in) {
        char[] letters = in.toCharArray();
        if (letters.length == 1) {
            char letter = letters[0];
            int guessedLettersNow = word.checkLetter(letter);
            if (guessedLettersNow > 0) {
                if (guessedLetters.contains(letter)) {
                    OutputManager.showMessage("Такая буква уже была");
                } else {
                    guessedLettersCounter += guessedLettersNow;
                    guessedLetters.add(letter);
                    OutputManager.showWord(word.word(), guessedLetters);
                }
                if (guessedLettersCounter == word.getNumberOfLetters()) {
                    winGame();
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
