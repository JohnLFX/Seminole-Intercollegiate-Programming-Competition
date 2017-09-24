package year2016;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <h3>Largest Number in List</h3>
 * <p>Read a list of integer numbers from a text file.
 * Each number in the file will be separated with a space.
 * Find the largest number in the list and how many times that number appears in the list.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class LargestNumberInList {

    public static void main(String[] args) throws IOException {

        //This reads data from a file.
        Path dataFile = Paths.get("C:\\Temp\\LargestNumber.txt");
        String input = new String(Files.readAllBytes(dataFile), StandardCharsets.ISO_8859_1).trim();

        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split(Pattern.quote(" "))) {

            numbers.add(Integer.valueOf(s));

        }

        //Sort by ascending order
        Collections.sort(numbers);
        Collections.reverse(numbers);

        //Get the largest number
        int largestNumber = numbers.get(0);

        //Remove everything else
        for (Iterator<Integer> it = numbers.iterator(); it.hasNext(); )
            if (it.next() != largestNumber)
                it.remove();

        System.out.println("The largest number is " + largestNumber + " and it occurs " + numbers.size() + " time(s).");

    }

}
