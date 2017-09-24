package year2015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>Magic Numbers</h3>
 * <p>Develop a program that can determine if each segment (starting from the left)
 * of a number is even divisible by the number of digits in that segment. What? Consider the number 4412.
 * The first segment is 4, the second is 44, the third is 441, and the last segment is 4412.
 * Each of those segments must be evenly divisible by the number of digits
 * in that segment as shown below to be called a magic number.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2015">Problem Descrption and Requirements</a>
 */
public class MagicNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a valid integer: ");

        final int input = scanner.nextInt();

        String str = String.valueOf(input);

        char[] chars = str.toCharArray();

        boolean isMagicNumber = true;

        for (int divisor = 1; divisor <= chars.length; divisor++) {

            int dividend = Integer.valueOf(new String(Arrays.copyOf(chars, divisor)));

            if ((dividend % divisor) != 0) {

                isMagicNumber = false;
                break;

            }

        }

        System.out.println(input + " is " + (isMagicNumber ? "" : "not ") + "a magic number!");

        scanner.close();

    }

}
