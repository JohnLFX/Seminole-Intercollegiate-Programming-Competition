package year2016;

import java.util.Scanner;

/**
 * <h3>Look-and-say Sequence</h3>
 * <p>Given a number, display the next number in the look-and-say sequence.
 * The look-and-say sequence is determined by looking at the number,
 * saying the number of times that each digit appears consecutively and then the digit itself.
 * For example, given 3111 the next number in sequence would be 1331 because
 * the number entered (3111) was composed of one 3 followed by three 1s.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class LookAndSaySequence {

    public static void main(String[] args) {

        //"Prompt for and accept as input a positive integer having a minimum of one digit.
        // You do not need to edit this input.
        // Only valid positive integer values will be entered."
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a valid positive integer: ");

        String str = scanner.nextLine();
        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];

            int count = 0;

            for (int s = (i); s < chars.length; s++) {

                if (chars[s] == c) {
                    count++;
                    if (count > 1)
                        i++;
                } else {
                    break;
                }
            }

            if (count > 0)
                builder.append(count).append(c);

        }

        System.out.println(builder.toString());

        scanner.close();

    }

}
