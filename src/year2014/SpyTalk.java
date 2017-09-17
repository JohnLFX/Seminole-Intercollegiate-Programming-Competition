package year2014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Spy Talk</h3>
 * <p>One of the little known strategies of covert CIA agents is that they can identify
 * each other in the field using a secret strategy.  When they meet each other,
 * the first covert agent will say a greeting to the second, who must respond using words
 * that contain only letters that appear in the original greeting.
 * In this problem you will be given a greeting and a response.
 * You must determine if the response identifies a CIA spy.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2014">Problem Descrption and Requirements</a>
 */
public class SpyTalk {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter greeting: ");
        String greeting = scanner.nextLine().toLowerCase();

        System.out.println("Enter response: ");
        String response = scanner.nextLine().toLowerCase();

        scanner.close();

        List<Character> greetingAlphabeticChars = new ArrayList<>();

        for (char c : greeting.toCharArray())
            if (Character.isAlphabetic(c))
                greetingAlphabeticChars.add(c);

        for (char c : response.toCharArray()) {
            if (Character.isAlphabetic(c) && !greetingAlphabeticChars.contains(c)) {
                System.out.println("You're not a secret agent!");
                return;
            }
        }

        System.out.println("That's my secret contact!");

    }

}
