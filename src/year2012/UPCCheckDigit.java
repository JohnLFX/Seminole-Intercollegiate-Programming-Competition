package year2012;

import java.util.Scanner;

/**
 * <h3>UPC Check Digit</h3>
 * <p>The most common form of Universal Product Code (UPC) is UPC-A
 * which has 12 digits arranged to make a unique number.
 * The twelfth digit is a check digit calculated
 * based on the values in digits one through eleven.
 * Calculate a UPC-A check digit given the eleven digits.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2012">Problem Descrption and Requirements</a>
 */
public class UPCCheckDigit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] inputChars = input.toCharArray();

        scanner.close();

        if (input.length() != 11)
            throw new IllegalArgumentException("Input must be 11 digits only");

        int checkNumber = 0;

        //Add the digits in the odd numbered positions (first, third, fifth, ...)

        int sumOddDigits = 0;

        for (int i = 0; i < 11; i += 2) {

            int digit = Character.getNumericValue(inputChars[i]);

            sumOddDigits += digit;

        }

        checkNumber += sumOddDigits;

        //Multiply the above sum by three.

        checkNumber *= 3;

        //Add the digits in the even numbered positions (second, fourth, sixth, …) to the total from above

        int sumEvenDigits = 0;

        for (int i = 0; i < 11; i++) {

            if (i % 2 == 0)
                continue;

            int digit = Character.getNumericValue(inputChars[i]);

            sumEvenDigits += digit;

        }

        checkNumber += sumEvenDigits;

        //Find the remainder when you divide the result by ten

        int remainder = (checkNumber % 10);

        //The check digit is zero if the remainder is zero

        if (remainder == 0)
            checkNumber = 0;
        else ////Otherwise subtract the remainder from ten to get the check digit.
            checkNumber = 10 - remainder;

        System.out.println("Check digit for " + input + " is " + checkNumber);


    }

}
