package year2015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>Wraparound Numbers</h3>
 * <p>A wraparound number occurs when you can use each
 * digit in the number to "locate" the next digit to visit
 * and you can visit all the digits once without
 * visiting any digit more than once.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2015">Problem Descrption and Requirements</a>
 */
public class WraparoundNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a valid positive integer that is > 0:");
        final long input = scanner.nextLong();

        if (input <= 0)
            throw new IllegalArgumentException("Invalid integer entered");

        char[] chars = String.valueOf(input).toCharArray();

        int[] digits = new int[chars.length];

        for (int i = 0; i < chars.length; i++)
            digits[i] = Integer.valueOf(String.valueOf(chars[i]));

        boolean[] visited = new boolean[digits.length];
        Arrays.fill(visited, false);//Probably not necessary

        int position = 0;

        boolean isRepeating = false;

        //"Always start with the left most digit"
        while (!isRepeating) {

            if (!visited[position]) {

                visited[position] = true;

                if (areAllBooleansTrue(visited))
                    break;

                int count = digits[position];

                int newPosition = (position + count);

                if (newPosition >= digits.length)
                    newPosition -= digits.length;

                position = newPosition;

            } else {

                isRepeating = true;

            }

        }

        System.out.println(input + " is " + (isRepeating ? "not " : "") + "a wraparound number.");

        scanner.close();

    }

    private static boolean areAllBooleansTrue(boolean[] array) {
        for (boolean b : array)
            if (!b)
                return false;

        return true;
    }

}
