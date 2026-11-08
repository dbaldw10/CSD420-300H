
import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }
        return uniqueList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }
        System.out.println("Original ArrayList (50 values):");
        System.out.println(originalList);
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nArrayList without duplicates:");
        System.out.println(uniqueList);
        System.out.println("Number of unique values: " + uniqueList.size());
    }
}
