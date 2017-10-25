package year2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h3>Isogram</h3>
 * <p>An isogram is a word or phrase without a repeating letter.
 * In this problem you will read a list of words or phrases from a text file.
 * Each word or phrase to be tested will be on its own line in the file.
 * For each word or phrase, display the word or phrase and then
 * display either "is an isogram" or "is not an isogram".</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2017">Problem Descrption and Requirements</a>
 */
public class Isogram {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(Isogram.class.getResourceAsStream("isogram.txt")));

        String line;

        while ((line = br.readLine()) != null) {

            if (isIsogram(line))
                System.out.println(line + " is an isogram");
            else
                System.out.println(line + " is not an isogram");

        }

        br.close();

    }

    private static boolean isIsogram(String str) {
        for (char c : str.toLowerCase().toCharArray())
            if (Character.isLetter(c) && str.indexOf(c) != str.lastIndexOf(c))
                return false;

        return true;
    }

}
