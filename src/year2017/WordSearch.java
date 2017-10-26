package year2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordSearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(WordSearch.class.getResourceAsStream("wordsearch1.txt"));
        String fileContents = scanner.nextLine();
        scanner.close();

        String[] fileData = fileContents.split(Pattern.quote(" "));

        int maxRows = Integer.parseInt(fileData[0]);
        int maxColumns = Integer.parseInt(fileData[1]);

        char[][] grid = new char[maxRows][maxColumns];

        int row = 0;
        int column = 0;

        for (int i = 2; i < fileData.length; i++) {
            grid[row][column] = fileData[i].charAt(0);
            if (++column >= maxColumns) {
                column = 0;
                row++;
            }
        }

        scanner = new Scanner(System.in);

        System.out.println("Enter the word: ");
        final String word = scanner.nextLine();
        scanner.close();

        List<Coordinate> possibleStarts = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (row = 0; row < maxRows; row++) {
            for (column = 0; column < maxColumns; column++) {
                if (wordChars[0] == grid[row][column]) {
                    possibleStarts.add(new Coordinate(row, column));//Coordinate class is in MaximalLayers
                }
            }
        }

        if (!possibleStarts.isEmpty()) {

            boolean foundPath = false;

            for (Coordinate startCoordinate : possibleStarts) {

                int index = 1;
                boolean foundMod = true;

                Coordinate coord = startCoordinate;

                List<Coordinate> path = new ArrayList<>();
                path.add(startCoordinate);

                while (foundMod && index < wordChars.length) {

                    foundMod = false;

                    for (int modX = -1; modX <= 1; modX++) {
                        for (int modY = -1; modY <= 1; modY++) {
                            if (foundMod || Math.abs(modX) == Math.abs(modY))
                                continue;

                            int cx = (coord.x + modX);
                            int cy = (coord.y + modY);

                            if (cx < 0 || cy < 0 || cx >= maxRows || cy >= maxColumns)
                                continue;

                            if (wordChars[index] == grid[cx][cy]) {

                                coord = new Coordinate(cx, cy);
                                path.add(coord);
                                index++;
                                foundMod = true;
                                break;

                            }

                        }
                    }

                }

                if (foundMod && index >= wordChars.length) {

                    foundPath = true;

                    index = 0;
                    for (Coordinate coordinate : path) {
                        System.out.print(wordChars[index++] + ":" + (coordinate.x + 1) + "," + (coordinate.y + 1) + " ");
                    }

                    System.out.println();

                    break;

                }

            }

            if (!foundPath)
                System.out.println("Cannot find the word " + word);

        } else {
            System.out.println("Cannot find the word " + word);
        }

    }

    private static int clamp(int value, int min, int max) {
        return (value < min) ? min : (value > max) ? max : value;
    }

}
