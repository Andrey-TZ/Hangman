package backend.academy.classes.utils;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class OutManager {

    public static void out(HangMan hangMan, int tries) {
        System.out.println(hangMan);
        System.out.print("Попыток осталось: ");
        System.out.println(tries);
    }

    public static void showWord(String word, ArrayList<Character> guessedLetters){
        for (char letter : word.toCharArray()){
            if (guessedLetters.contains(letter)){
                System.out.print(letter);
            }
            else System.out.print("_");
        }
        System.out.println(" ");
    }

    public static void win(String word, int tries){
        System.out.printf("Поздравляю - вы отгадали слово '%s' за %d попыток.", word, tries);
    }

    public static void loose(String word){
        System.out.printf("К сожалению вы не отгадали слово '%s'\n В следующий раз у вас точно получится!", word);

    }
}
