package year2014;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <h3>Digital Root</h3>
 * <p>The digital root of a number is obtained by summing its individual digits,
 * summing those individual digits, and continuing the process until the final sum
 * is a single digit (that is, less than 10). For example, the digital root of 1234 is 1</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2014">Problem Descrption and Requirements</a>
 */
public class DigitalRoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a non-negative integer number: ");

        final int input = Math.abs(scanner.nextInt());

        scanner.close();

        int digitalRoot = input;

        while (digitalRoot > 9)
            digitalRoot = sumIndividualDigits(digitalRoot);

        System.out.println("The digital root of " + input + " is " + digitalRoot);

    }

    private static int sumIndividualDigits(int input) {
        if (input < 0)
            throw new IllegalArgumentException("Input must be positive");

        char[] chars = String.valueOf(input).toCharArray();

        return IntStream.range(0, chars.length)
                .map(i -> Character.getNumericValue(chars[i])).sum();
    }

}
