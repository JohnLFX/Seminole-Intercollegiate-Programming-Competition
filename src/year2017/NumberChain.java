package year2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h3>Number Chain</h3>
 * <p>Given a number, we can form a number chain by:</p>
 * <ol>
 * <li>Arranging its digits in descending order.</li>
 * <li>Arranging its digits in ascending order.</li>
 * <li>Subtracting the number obtained in (2) from the number obtained (1) to form a new number.</li>
 * <li>Repeating these steps until the new number matches the result from the previous calculation.</li>
 * </ol>
 * <p>Determine how many iterations this process took. If it is over 1000, break the loop.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2017">Problem Descrption and Requirements</a>
 */
public class NumberChain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(Isogram.class.getResourceAsStream("numberchain.txt")));

        String line;

        while ((line = br.readLine()) != null) {

            int number = Integer.parseInt(line);
            int iterations = 1;
            int previous = 0;

            while ((number = chainLength(number)) != previous) {
                previous = number;
                if (++iterations > 1000)
                    break;
            }

            System.out.println("original number was " + line + " and chain length "
                    + ((iterations > 1000) ? "> 1000" : "= " + iterations));

        }

        br.close();

    }

    private static int chainLength(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        Arrays.sort(chars);

        int a = Integer.parseInt(String.valueOf(chars));
        int b = Integer.parseInt(reverse(String.valueOf(chars)));

        return b - a;
    }

    private static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

}
