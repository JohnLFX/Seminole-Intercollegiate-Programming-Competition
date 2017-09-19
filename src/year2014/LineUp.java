package year2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <h3>Line Up</h3>
 * <p>A group of boys and girls line up by height in separate classrooms –
 * boys in one room and girls in a different room. Eventually they must be
 * merged into one line arranged by height with the shortest student first.
 * You need to write an application that merges a list containing the heights
 * of the girls with a list containing the heights of the boys.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2014">Problem Descrption and Requirements</a>
 */
public class LineUp {

    public static void main(String[] args) {

        //I can tell that this problem was designed for C.
        //With the powers of Collections.sort and ArrayList, this problem
        //can be solved without all the other questions.

        Scanner scanner = new Scanner(System.in);

        List<Integer> totalHeights = new ArrayList<>();

        System.out.println("Enter number of boys: ");

        scanner.nextLine();

        System.out.println("Enter values for boys separated by a space: ");

        for (String s : scanner.nextLine().split(Pattern.quote(" ")))
            totalHeights.add(Integer.parseInt(s));

        System.out.println("Enter number of girls: ");

        scanner.nextLine();

        System.out.println("Enter values for girls separated by a space: ");

        for (String s : scanner.nextLine().split(Pattern.quote(" ")))
            totalHeights.add(Integer.parseInt(s));

        Collections.sort(totalHeights);

        System.out.print("Line up: ");

        for (int i : totalHeights)
            System.out.print(i + " ");

        System.out.println();

    }

}
