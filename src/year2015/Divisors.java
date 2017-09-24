package year2015;

import java.util.Scanner;

/**
 * <h3>Divisors</h3>
 * <p>Find all numbers between X and Y inclusive that have exactly N even divisors (i.e. remainder = 0).
 * X, Y, and N are all positive integers greater than zero. Also X < Y.
 * For example, if X = 4, Y = 14, and N = 3, we want to find all numbers between 4 and 14 (inclusive)
 * that have exactly 3 numbers which divide that number evenly.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2015">Problem Descrption and Requirements</a>
 */
public class Divisors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer for x: ");
        final int x = scanner.nextInt();

        System.out.println("Enter an integer for y: ");
        final int y = scanner.nextInt();

        System.out.println("Enter an integer for n: ");
        final int n = scanner.nextInt();

        if (x > y)
            throw new IllegalArgumentException("X must be less than Y, as defined in the description");

        for (int i = x; i <= y; i++) {

            int divisorCount = 0;

            for (int a = 1; a <= i; a++) {

                if ((i % a) == 0) {

                    divisorCount++;

                }

            }

            if (divisorCount == n) {

                System.out.print(i + " ");

            }

        }

        System.out.println();

        scanner.close();

    }

}
