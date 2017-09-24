package year2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Are You My Type?</h3>
 * <p>Positive integers can be classified as abundant, deficient, or perfect.
 * Abundant integers are those whose proper factors sum to a larger number.
 * For example, 36 is an abundant number because its proper factors (1, 2, 3, 4, 6, 9, 12, 18)
 * sum to 55 which is greater than 36. Deficient integers are those whose proper factors
 * sum to a smaller number. For example, 27 is a deficient integer because its proper factors (1, 3, 9)
 * sum to 13 which is less than 27. Perfect integers are those whose proper factors sum to exactly that number.
 * For example, 28 is a perfect integer because its proper factors (1, 2, 4, 7, 14) sum to exactly 28.
 * Given a positive integer value, determine if it is abundant, deficient, or perfect.
 * Also list its perfect factors and the sum of those perfect factors.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class AreYouMyType {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //"Prompt for and accept as input a positive integer having a minimum of one digit.
        // You do not need to edit this input.
        // Only valid positive integer values will be entered."

        System.out.println("Enter a positive integer value: ");
        final int givenNumber = Math.abs(scanner.nextInt());

        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i < givenNumber; i++) {

            if (givenNumber % i == 0) {

                factors.add(i);

            }

        }

        factors = Collections.unmodifiableList(factors);

        int sum = factors.stream().mapToInt(Integer::intValue).sum();

        System.out.println((sum > givenNumber ? "Abundant" : (sum == givenNumber ? "Perfect" : "Deficient"))
                + " Factors are: " + factors.toString());

        System.out.println("Sum is: " + sum);

        scanner.close();

    }

}
