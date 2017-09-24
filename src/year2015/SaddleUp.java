package year2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h3>Saddle Up!</h3>
 * <p>In any 2 dimensional array, there can be a maximum of two separate "saddle" points (or cells).
 * Saddle point 1 will contain a value larger than any other in its row and smaller than any other in its column.
 * Saddle point 2 will contain a value smaller than any other in its row and larger than any other in its column.</p>
 * <p>Develop a program that will determine each saddle point, if any, for a given two dimensional array.
 * Display the row and column for each type of saddle point. Read the array values from a text file.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2015">Problem Descrption and Requirements</a>
 */
public class SaddleUp {

    public static void main(String[] args) throws IOException {

        List<String> lines;

        try (InputStream resource = SaddleUp.class.getResourceAsStream("/year2015/saddlepointdata.txt")) {
            lines = new BufferedReader(
                    new InputStreamReader(resource, StandardCharsets.US_ASCII))
                    .lines().collect(Collectors.toList());
        }

        //lines = Files.readAllLines(Paths.get("data.txt"));

        final int rows = Integer.valueOf(lines.get(0).trim());//The first line in the file will be the number of rows in the array.
        final int columns = Integer.valueOf(lines.get(1).trim());//The second line in the file will be the number of columns in the array.

        int[][] array = new int[rows][columns];

        /*
        Each line in the remainder of the file will be a value for the array.
        For example, line 3 will contain array element 0, 0, line 4 will contain 0, 1, etc.
         */

        int currentRow = 0;
        int currentColumn = 0;

        for (int i = 2; i < lines.size(); i++) {

            if (currentRow >= rows)
                throw new IllegalStateException("Too much data in text file (currentRow=" + currentRow + ", rows=" + rows + ")");

            String str = lines.get(i).trim();

            if (str.isEmpty())
                continue;

            int value = Integer.valueOf(str);

            array[currentRow][currentColumn] = value;

            System.out.println("Setting (" + currentRow + ", " + currentColumn + ") = " + value);

            currentColumn++;

            if (currentColumn >= columns) {
                currentColumn = 0;
                currentRow++;
            }

        }

        System.out.println("---Saddle Points---");

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {

                int testValue = array[rowIndex][columnIndex];

                //Test row values

                boolean passedRowTest = true;

                for (int testRowIndex = 0; testRowIndex < rows; testRowIndex++) {

                    int comparedValue = array[testRowIndex][columnIndex];

                    if (testValue > comparedValue) {

                        passedRowTest = false;

                    }

                }

                if (passedRowTest) {

                    boolean passedColumnTest = true;

                    for (int testColumnIndex = 0; testColumnIndex < columns; testColumnIndex++) {

                        int comparedValue = array[rowIndex][testColumnIndex];

                        if (testValue < comparedValue) {

                            passedColumnTest = false;

                        }

                    }

                    if (passedColumnTest) {

                        System.out.println("Saddle point " + testValue + " located at" +
                                " (Row " + (rowIndex + 1) + ", Column " + (columnIndex + 1) + ")");

                    }

                }

            }

        }

    }

}
