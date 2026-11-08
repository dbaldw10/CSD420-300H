import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new FileReader("Dallas datafile.dat"))) {
            String line;
            System.out.println("Contents of Dallas datafile.dat:");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
