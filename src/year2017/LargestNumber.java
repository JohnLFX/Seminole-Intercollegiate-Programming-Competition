package year2017;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <h3>Largest Number</h3>
 * <p>Determine the largest number that can be formed from a group of individual numbers.
 * For example, given the numbers 50, 2, 1, 9 the largest number that can be formed is 95021.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2017">Problem Descrption and Requirements</a>
 */
public class LargestNumber {

    public static void main(String[] args) {

        /*
            This will read data from a file. To keep things simple, a test value is hard-coded.
            Exceptions do not need to be handled for this problem.
            //String input = new String(Files.readAllBytes(Paths.get("largestnumber1.txt")), StandardCharsets.US_ASCII);
        */

        String input = "201 3 77 5632 41 18";

        List<Integer> numbers = Arrays.stream(input.trim().split(Pattern.quote(" ")))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        numbers.sort((o1, o2) -> {
            int first1 = determineFirstDigit(o1);
            int first2 = determineFirstDigit(o2);

            if (first1 == first2) {
                return o2.compareTo(o1);
            } else {
                return (first1 > first2) ? -1 : 1;
            }
        });

        System.out.println("Input: " + input);

        System.out.println(
                "Largest Number: " + numbers.stream().map(Object::toString).collect(Collectors.joining())
        );

    }

    private static int determineFirstDigit(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Must be positive");

        if (number < 10)
            return number;

        return Character.getNumericValue(String.valueOf(number).charAt(0));
    }

}
