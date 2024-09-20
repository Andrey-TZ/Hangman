package backend.academy.classes.utils;

import backend.academy.classes.Word;
import java.util.ArrayList;

public class GameSession {
    private static boolean gameStarted = false;
    private static boolean gameEnded = false;
    private static Word word;
    private static int countOfGuessedLetters = 0;
    private static final ArrayList<Character> guessedLetters = new ArrayList<>();
    private static int mistakesCurrent = 0;
    private static int mistakesMax;
    private static HangMan hangMan;

    public static void startGame(int level) {
        mistakesMax = 9 - (level - 1) * level;
        hangMan = new HangMan();
        gameStarted = true;
        word = new Word(" ", " ", 1);
    }

    public static void addMistake() {
        if (mistakesMax == 9 || (mistakesMax == 7 && (mistakesCurrent == 4 || mistakesCurrent == 6))) {
            hangMan.addMistake();
        }
        hangMan.addMistake();
        mistakesCurrent++;

        OutManager.out(hangMan, mistakesMax-mistakesCurrent);
    }

    public static void endGame(boolean isWin){
        gameEnded = true;
        if(isWin){
            OutManager.win(word.word(), mistakesMax-mistakesCurrent);
        }
        else OutManager.loose(word.word());
    }

    public static void run() {
        String input;
        while(!gameStarted){
            input = INManager.requestString("Введите команду: ");
            CommandManager.start(input);
        }
        while(!gameEnded){
            input = INManager.requestString("Введите букву или команду: ");
            guessLetter(input);
            CommandManager.start(input);
        }
        System.exit(0);
    }

    public static void guessLetter(String in) {
        char[] letters = in.toCharArray();
        if (letters.length == 1) {
            char letter = letters[0];
            int guessedLettersNow = word.checkLetter(letter);
            if (guessedLettersNow > 0){
                guessedLetters.add(letter);
                OutManager.showWord(word.word(), guessedLetters);
                countOfGuessedLetters = countOfGuessedLetters + guessedLettersNow;
                if (countOfGuessedLetters == word.numberOfLetters()) endGame(true);
            }
            else{
                addMistake();
            }

        } else {
            System.out.println("Введено больше одной буквы");
        }
    }
}
