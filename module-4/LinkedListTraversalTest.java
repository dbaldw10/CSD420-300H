import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {
    public static long traverseWithIterator(LinkedList<Integer> list) {
        long total = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            total += iterator.next();
        }
        return total;
    }
    public static long traverseWithGet(LinkedList<Integer> list) {
        long total = 0;

        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        return total;
    }
    public static void runTests() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        checkResults(emptyList, 0);

        LinkedList<Integer> oneItem = new LinkedList<>();
        oneItem.add(7);
        checkResults(oneItem, 7);

        LinkedList<Integer> severalItems = new LinkedList<>();
        severalItems.add(10);
        severalItems.add(20);
        severalItems.add(10);
        severalItems.add(-5);
        checkResults(severalItems, 35);

        System.out.println("Small test cases passed.\n");
    }

    private static void checkResults(LinkedList<Integer> list, long expected) {
        if (traverseWithIterator(list) != expected ||
                traverseWithGet(list) != expected) {
            throw new AssertionError("Traversal test failed!");
        }
    }

    public static void runTimingTest(int size) {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        long expected = (long) size * (size + 1) / 2;

        long start = System.nanoTime();
        long iteratorTotal = traverseWithIterator(numbers);
        long iteratorTime = System.nanoTime() - start;

        start = System.nanoTime();
        long getTotal = traverseWithGet(numbers);
        long getTime = System.nanoTime() - start;

        if (iteratorTotal != expected || getTotal != expected) {
            throw new AssertionError("Incorrect total for list size " + size);
        }

        double iteratorMs = iteratorTime / 1_000_000.0;
        double getMs = getTime / 1_000_000.0;

        System.out.println("List size: " + size);
        System.out.printf("Iterator traversal: %.3f ms%n", iteratorMs);
        System.out.printf("get(index) traversal: %.3f ms%n", getMs);
        System.out.printf("get(index) / iterator: %.1f times slower%n%n",
                getMs / iteratorMs);
    }

    public static void main(String[] args) {
        runTests();

        // Both required sizes are tested by default.
        runTimingTest(50_000);
        runTimingTest(500_000);
    }
}
