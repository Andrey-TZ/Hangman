package backend.academy.classes;

import java.util.Arrays;
import java.util.stream.IntStream;

// Класс для хранения информации о словах
public record Word(String word, String hint, int level, Character[] letters) {

    public Word(String word, String hint, int level) {
        // Добавляем массив букв
        this(word, hint, level,
            IntStream.range(0, word.length()).mapToObj(i -> word.toCharArray()[i]).toArray(Character[]::new));
    }

    public int checkLetter(Character letter) {
        return (int) Arrays.stream(letters).filter(x -> x.equals(letter)).count();
    }

    public int numberOfLetters() {
        return letters.length;
    }
}
