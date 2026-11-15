import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.NavigableSet;


public class WordCollectionTest {
    public static void main(String[] args) throws IOException {
        NavigableSet<String> words = WordCollection.readWords(WordCollection.FILE_WITH_WORDS);

        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        try (PrintStream output = new PrintStream(capturedOutput, true, "UTF-8")) {
            WordCollection.displayWords(words, output);
        }

        String expected = String.join(System.lineSeparator(),
                "Ascending order:",
                "apple",
                "banana",
                "grape",
                "orange",
                "pear",
                "",
                "Descending order:",
                "pear",
                "orange",
                "grape",
                "banana",
                "apple",
                "");

        String actual = new String(capturedOutput.toByteArray(), StandardCharsets.UTF_8);

        if (!expected.equals(actual)) {
            throw new AssertionError(
                    "Expected:\n" + expected + "\nActual:\n" + actual);
        }

        System.out.println("PASS: Duplicate words were removed and both sort orders are correct.");
    }
}
