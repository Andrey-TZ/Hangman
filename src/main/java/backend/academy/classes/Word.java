package backend.academy.classes;

import java.util.Collections;
import java.util.List;

// Класс для хранения информации о словах
public record Word(String word, String hint, int difficulty, List<Character> letters) {

    public Word(String word, String hint, int difficulty) {
        // Добавляем массив букв
        this(word, hint, difficulty,
            word.chars().mapToObj(i -> (char) i).toList());
    }

    public int checkLetter(Character letter) {
        return Collections.frequency(letters, letter);
    }

    public int getNumberOfLetters() {
        return letters.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Word another)) {
            return false;
        }
        return word.equals(another.word()) && hint.equals(another.hint()) && difficulty == another.difficulty();
    }

    @Override
    public int hashCode() {
        return word.hashCode() + hint.hashCode() + difficulty;
    }
}
