package year2017;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Maximal Layers</h3>
 * <p>Consider a group of points. Each point is made of an x and y coordinate.
 * A point from that group is considered maximal if there is
 * no other point in the group that is "north" and "east" of it.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2017">Problem Descrption and Requirements</a>
 */
public class MaximalLayers {

    public static void main(String[] args) {

        List<Coordinate> coordinates = new ArrayList<>();

        //Read from text file (use FileInputStream for real files)
        /*Scanner scanner = new Scanner(MaximalLayers.class.getResourceAsStream("/maximal.txt"));

		while (scanner.hasNextInt())
			coordinates.add(new Coordinate(scanner.nextInt(), scanner.nextInt()));

		scanner.close();*/

        //Test data set 1
        /*coordinates.addAll(Arrays.asList(
				new Coordinate(5, 5),
				new Coordinate(4, 9),
				new Coordinate(10, 2),
				new Coordinate(2, 3),
				new Coordinate(15, 7)
		));*/

        int layer = 1;

        while (!coordinates.isEmpty()) {

            System.out.print("Layer " + layer + ": ");
            layer++;

            List<Coordinate> maximalCoordinateOrder = new ArrayList<>();

            for (Coordinate c : coordinates) {

                boolean foundMoreNorth = false;
                boolean foundMoreEast = false;

                for (Coordinate o : coordinates) {

                    if (o.equals(c))
                        continue;

                    if (o.x > c.x)
                        foundMoreNorth = true;

                    if (o.y > c.y)
                        foundMoreEast = true;

                }

                if (!foundMoreNorth || !foundMoreEast) {

                    System.out.print(c.toString() + " ");
                    maximalCoordinateOrder.add(c);

                }

            }

            coordinates.removeAll(maximalCoordinateOrder);

            System.out.println();

        }


    }

}

class Coordinate {

    public final int x, y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Coordinate) {
            Coordinate that = (Coordinate) o;

            return x == that.x && y == that.y;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}