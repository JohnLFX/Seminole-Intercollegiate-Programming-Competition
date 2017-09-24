package year2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Spaced Out</h3>
 * <p>Given 3 different integer numbers, determine if the difference between the
 * smallest number and the middle number is the same as the difference between the
 * middle number and the largest number. The numbers can be entered in any order.
 * If the differences are exactly the same the program should indicate
 * the numbers are "Spaced Out" otherwise the numbers are "NOT Spaced Out".</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class SpacedOut {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Prompt for and accept as input three integers.
        // You do not need to edit this input.
        // Only valid positive integer values will be entered.

        //Using a list to sort since "The numbers can be entered in any order."
        List<Integer> data = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {

            System.out.println("Enter number " + i + ": ");
            data.add(scanner.nextInt());

        }

        //Sort by descending order
        Collections.sort(data);
        Collections.reverse(data);

        System.out.println(data.toString());

        //Determine if the
        // difference between the smallest number and the middle number is
        // the same as the difference between the middle number and the largest number.

        if (Math.abs((data.get(2) - data.get(1))) == Math.abs((data.get(1) - data.get(0)))) {

            System.out.println("Spaced Out");

        } else {

            System.out.println("NOT Spaced Out");

        }

        scanner.close();

    }

}
