package backend.academy.classes.handlers;

import backend.academy.classes.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectionManagerTest {
    private CollectionManager collectionManager;

    @BeforeEach
    void setUp() {
        collectionManager = new CollectionManager();

    }

    @Test
    void getRandomWord() {
        collectionManager.initialise("src/test/resources/test_collection.csv");
        Word word_expected = new Word("тест", "то, что я сейчас пишу", 1);

        Word word = collectionManager.getRandomWord(1);

        Assertions.assertEquals(word_expected, word);
    }

    @Test
    void initialise_wrongFile() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            collectionManager.initialise("wrong_file.csv");
        });

        Assertions.assertEquals("Wrong file", thrown.getMessage());
    }

}
