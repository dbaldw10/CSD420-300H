import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;


public class WordCollection {
    public static final Path FILE_WITH_WORDS = Paths.get("collection_of_words.txt");

    public static void main(String[] args) {
        try {
            displayWords(readWords(FILE_WITH_WORDS), System.out);
        } catch (IOException e) {
            System.err.println("Could not read " + FILE_WITH_WORDS + ": " + e.getMessage());
        }
    }

    public static NavigableSet<String> readWords(Path file) throws IOException {
        NavigableSet<String> words = new TreeSet<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase(Locale.ROOT).split("[^\\p{L}]+")) {
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
        }

        return words;
    }

    public static void displayWords(NavigableSet<String> words, PrintStream output) {
        output.println("Ascending order:");
        for (String word : words) {
            output.println(word);
        }

        output.println();
        output.println("Descending order:");
        for (String word : words.descendingSet()) {
            output.println(word);
        }
    }
}