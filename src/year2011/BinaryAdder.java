package year2011;

import java.util.Scanner;

/**
 * <h3>Binary Adder</h3></h3>
 * <p>Create an application that accepts a binary number and a decimal number as input.
 * Add these numbers. Display the sum as a binary number.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2011">Problem Descrption and Requirements</a>
 */
public class BinaryAdder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter binary number: ");

        int binaryNumberBase10 = Integer.parseInt(scanner.nextLine(), 2);

        System.out.println("Enter decimal number: ");

        int decimalNumber = scanner.nextInt();

        scanner.close();

        int result = (binaryNumberBase10 + decimalNumber);

        System.out.println("Binary sum is: " + Integer.toString(result, 2));

    }

}
