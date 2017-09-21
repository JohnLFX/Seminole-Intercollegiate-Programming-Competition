package year2013;

import java.util.Scanner;

/**
 * <h3>Palindrome</h3>
 * <p>A palindrome is a word that is the same forward as backward:
 * "mom" and "bib" are examples. Positive integers can be palindromic.
 * For example the numbers 3, 484, 12621, and 458854 are all palindromic.
 * How many palindromic integers are there between x and y inclusive
 * given that x will be > 0 and y will be <= 1,000,000?</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2013">Problem Descrption and Requirements</a>
 */
public class Palindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        scanner.close();

        int count = 0;

        for (int i = x; i <= y; i++) {

            if (isPalindrome(String.valueOf(i))) {

                count++;

            }

        }

        System.out.println(count);

    }

    private static boolean isPalindrome(String str) {

        return new StringBuilder(str).reverse().toString().equals(str);

    }

}
