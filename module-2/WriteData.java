import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        int[] integers = new int[5];
        double[] doubles = new double[5];
        Random random = new Random();

        // Fill both arrays with random values.
        for (int i = 0; i < 5; i++) {
            integers[i] = random.nextInt(100) + 1;
            doubles[i] = random.nextDouble() * 100;
        }

        // The second argument, true, appends instead of overwriting. FileWriter creates the file if it does not already exist.
        try (PrintWriter output = new PrintWriter(new FileWriter("Dallas datafile.dat", true))) {
            output.print("Integers:");
            for (int number : integers) {
                output.print(" " + number);
            }
            output.println();

            output.print("Doubles:");
            for (double number : doubles) {
                output.printf(Locale.US, " %.2f", number);
            }
            output.println();
            output.println(); // Separate each batch of random numbers.

            System.out.println("Data was written to Dallas datafile.dat");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
