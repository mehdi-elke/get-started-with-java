
package fr.baretto;

public class FizzBuzzTest {
    public static void main(String[] args) {
        testFizzBuzz();
    }

    private static void testFizzBuzz() {
        StringBuilder results = new StringBuilder();

        // Capture the output for numbers 1 to 15
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.append("FizzBuzz");
            } else if (i % 3 == 0) {
                results.append("Fizz");
            } else if (i % 5 == 0) {
                results.append("Buzz");
            } else {
                results.append(i);
            }
            results.append("\n");
        }

        // Print the results
        System.out.println(results.toString());
    }
}
