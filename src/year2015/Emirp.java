package year2015;

import java.util.Scanner;

/**
 * <h3>Emirp</h3>
 * <p>A prime number is a number greater than 1 that is divisible evenly only by 1 and itself.
 * Find each prime number between X and Y that has a palindrome that is also prime.
 * For example the number 17 is prime and its palindrome, 71, is also prime.
 * X and Y will be integers such that X > 1 and Y > 1. Also X < Y.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2015">Problem Descrption and Requirements</a>
 */
public class Emirp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer for x: ");
        final int x = scanner.nextInt();

        System.out.println("Enter an integer for y: ");
        final int y = scanner.nextInt();

        if (x <= 1)
            throw new IllegalArgumentException("X must be > 1 as defined in the description");

        if (y <= 1)
            throw new IllegalArgumentException("X must be > 1 as defined in the description");

        if (x > y)
            throw new IllegalArgumentException("X must be less than Y, as defined in the description");

        for (int i = x; i < y; i++) {

            int palindromeNumber = Integer.valueOf(reverse(String.valueOf(i)));

            if (isPrime(i) && isPrime(palindromeNumber)) {

                System.out.print(i + " ");

            }

        }

        System.out.println();

        scanner.close();

    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
