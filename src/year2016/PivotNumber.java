package year2016;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <h3>Pivot Number</h3>
 * <p>Partition a list. Given a list of integer numbers and an integer pivot number,
 * display all the numbers less than the pivot, the pivot number, and then all
 * the numbers greater than the pivot. Read the list from a text file.
 * The first number in the file will be the pivot number.
 * The numbers before and after the pivot number must be
 * in same order as found in the file (list).</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class PivotNumber {

    public static void main(String[] args) throws IOException {

        //TODO Optimize this file

        Path dataFile = Paths.get("C:\\Temp\\PivotNumber.txt");

        String input = new String(Files.readAllBytes(dataFile), StandardCharsets.ISO_8859_1).trim();

        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split(Pattern.quote(" "))) {

            numbers.add(Integer.valueOf(s));

        }

        final int pivotNumber = numbers.get(0);

        List<Integer> lessNumbers = new ArrayList<>();
        List<Integer> greaterNumbers = new ArrayList<>();

        for (Integer n : numbers) {

            if (n < pivotNumber) {

                lessNumbers.add(n);

            } else {

                greaterNumbers.add(n);

            }

        }

        List<Integer> sortedNumbers = new ArrayList<>();

        sortedNumbers.addAll(lessNumbers);
        sortedNumbers.add(pivotNumber);
        sortedNumbers.addAll(greaterNumbers);

        String results = sortedNumbers.toString();

        results = results.replaceAll(Pattern.quote(","), "");
        results = results.replaceAll(Pattern.quote("]"), "");
        results = results.replaceAll(Pattern.quote("["), "");

        System.out.println(results);

    }

}
