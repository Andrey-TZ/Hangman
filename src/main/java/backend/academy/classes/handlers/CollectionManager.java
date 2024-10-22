package backend.academy.classes.handlers;

import backend.academy.classes.Word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionManager {
    private final ArrayList<Word> wordsCollection = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public void initialise(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line;
            boolean headerRead = false;
            while ((line = br.readLine()) != null) {
                // Пропускаем первую строку (заголовок)
                if (!headerRead) {
                    headerRead = true;
                    continue;
                }

                // Разделение строки по запятым
                String[] parts = line.split(";");

                Word word = new Word(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
                wordsCollection.add(word);
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong file", e);
        }
    }

    public Word getRandomWord(int difficulty) {
        List<Word> collectionByDifficulty =
            wordsCollection.stream().filter(word -> word.difficulty() == difficulty).toList();
        int randomIndex = RANDOM.nextInt(collectionByDifficulty.size());
        return collectionByDifficulty.get(randomIndex);
    }

}
