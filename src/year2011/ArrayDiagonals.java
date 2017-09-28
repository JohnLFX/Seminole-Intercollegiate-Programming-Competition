package year2011;

import java.util.Scanner;

/**
 * <h3>Array Diagonals</h3>
 * <p></p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2011">Problem Descrption and Requirements</a>
 */
public class ArrayDiagonals {

    public static void main(String[] args) {

        int[][] dataGrid = new int[5][5];

        //region Populate data
        dataGrid[0][0] = 22;
        dataGrid[0][1] = 14;
        dataGrid[0][2] = 7;
        dataGrid[0][3] = 5;
        dataGrid[0][4] = 23;

        dataGrid[1][0] = 13;
        dataGrid[1][1] = 21;
        dataGrid[1][2] = 4;
        dataGrid[1][3] = 17;
        dataGrid[1][4] = 6;

        dataGrid[2][0] = 2;
        dataGrid[2][1] = 18;
        dataGrid[2][2] = 10;
        dataGrid[2][3] = 12;
        dataGrid[2][4] = 1;

        dataGrid[3][0] = 8;
        dataGrid[3][1] = 25;
        dataGrid[3][2] = 3;
        dataGrid[3][3] = 11;
        dataGrid[3][4] = 9;

        dataGrid[4][0] = 30;
        dataGrid[4][1] = 27;
        dataGrid[4][2] = 15;
        dataGrid[4][3] = 16;
        dataGrid[4][4] = 24;
        //endregion

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer value: ");
        final int input = scanner.nextInt();

        scanner.close();

        int xCoordinate = -1;
        int yCoordinate = -1;

        for (int x = 0; x < dataGrid.length; x++) {

            for (int y = 0; y < dataGrid.length; y++) {

                if (dataGrid[x][y] == input) {

                    xCoordinate = x;
                    yCoordinate = y;
                    break;

                }

            }

        }

        if (xCoordinate == -1) {
            System.out.println("Value does not exist in the array.");
            return;
        }

        System.out.println("Position: " + xCoordinate + ", " + yCoordinate);

        int leftDiagSum = leftDiagSum(dataGrid, xCoordinate, yCoordinate);
        int rightDiagSum = rightDiagSum(dataGrid, xCoordinate, yCoordinate);

        System.out.println("The left diagonal sum is " + leftDiagSum);
        System.out.println("The right diagonal sum is " + rightDiagSum);

    }

    private static int leftDiagSum(int[][] dataGrid, int xCoordinate, int yCoordinate) {
        int leftDiagSum = 0;

        int y = yCoordinate;

        for (int x = (4 - xCoordinate); x < dataGrid.length; x++) {

            System.out.println(x + ", " + y);
            leftDiagSum += dataGrid[x][y];
            y++;

        }

        if (yCoordinate > 0) {

            y = (yCoordinate - 1);

            for (int x = (xCoordinate - 1); x > 0; x--) {

                System.out.println(x + ", " + y);
                leftDiagSum += dataGrid[x][y];
                y--;

                if (y < 0)
                    break;

            }

        }

        return leftDiagSum;
    }

    private static int rightDiagSum(int[][] dataGrid, int xCoordinate, int yCoordinate) {

    }

}