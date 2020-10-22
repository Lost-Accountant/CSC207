import java.util.Iterator;

public class TestIterable {
    public static void main(String [] args) {
        IterableString testString1 = new IterableString("Hi there!");

        System.out.println("Printing a string \"Hi there!\" in a for-each loop");

        for (char c: testString1) {
            System.out.println(c);
        }

        IterableString testString2 = new IterableString("");

        System.out.println("Printing an empty string in a for-each loop");
        for (char c: testString2) {
            System.out.println(c);
        }

        // an iterator that produces up to n-th fibonacci numbers (start at 0)
        IterableFibonacci fibNumbers = new IterableFibonacci(15);

        System.out.println("Fibonacci numbers up to n = 15");
        for (int fib: fibNumbers) {
            System.out.println(fib);
        }

        System.out.println("Fibonacci numbers up to n = 10");
        fibNumbers.setMaxIndex(10);
        for (int fib: fibNumbers) {
            System.out.println(fib);
        }

    }
}