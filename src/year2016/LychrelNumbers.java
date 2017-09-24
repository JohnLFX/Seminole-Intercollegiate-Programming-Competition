package year2016;

import java.util.Scanner;

/**
 * <h3>Lychrel Numbers</h3>
 * <p>According to Wikipedia a Lychrel number is a
 * "...natural number that cannot form a palindrome through
 * the iterative process of repeatedly reversing its
 * digits and adding the resulting numbers."</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class LychrelNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive integer number > 0: ");

        //"Start with an integer number > 0. Let’s call this n."
        int n = Math.abs(scanner.nextInt());

        int iterationCount = 0;

        while (!isPalindrome(n)) { //Repeat until the result is a palindrome.

            //"Add the reverse order digits of n to n."
            n += Integer.valueOf(reverse(String.valueOf(n)));//Cheap way to reverse the integer

            iterationCount++;

            //"To avoid long run times, stop after a maximum of 10 iterations"
            if (iterationCount >= 10)
                break;

        }

        System.out.println((isPalindrome(n) ? "Not" : "Still") + " a Lychrel number after " + iterationCount + " iterations: " + n);

        scanner.close();

    }

    private static boolean isPalindrome(int n) {

        String str = String.valueOf(n);

        return str.equals(reverse(str));

    }

    private static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
