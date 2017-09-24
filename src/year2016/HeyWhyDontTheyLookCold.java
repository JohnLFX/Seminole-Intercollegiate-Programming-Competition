package year2016;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

enum DirectionFace {
    WEST(-1, 0),
    EAST(1, 0),
    NORTH(0, -1),
    SOUTH(0, 1);

    public final int modX, modY;

    DirectionFace(int modX, int modY) {
        this.modX = modX;
        this.modY = modY;
    }

}

/**
 * <h3>Hey, Why Don't They Look Cold?</h3>
 * <p>The New England Patriots have a heated field to keep it from freezing in cold temperatures.
 * Under the grass is a grid of metal. A heat source is applied to the edges
 * (east edge, west edge, south edge, and north edge). The heat source can apply a
 * different constant temperature to each edge. The heat from the edges eventually is transmitted
 * throughout the "grid" heating the entire field.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class HeyWhyDontTheyLookCold {

    public static final int GRID_MAX_X = 10, GRID_MAX_Y = 10;
    public static final int RENDER_SCALE = 55;
    Map<Coordinate, Double> grid;

    public HeyWhyDontTheyLookCold() {
        RenderPanel renderPanel = new RenderPanel(this);

        JFrame displayFrame = new JFrame("Hey, Why Don't They Look Cold?");
        displayFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayFrame.setPreferredSize(new Dimension(580, 600));
        displayFrame.add(renderPanel);
        displayFrame.pack();
        //displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);

        this.grid = new HashMap<>();
        final DirectionFace[] directionFaces = DirectionFace.values();

        //region Populate the grid
        for (DirectionFace face : directionFaces) {

            double temperature = Double.valueOf(prompt(displayFrame,
                    "Enter " + face.name().toLowerCase() + " edge temperature:"));

            System.out.println(face.name().toLowerCase() + " edge temperature: " + temperature);

            Coordinate coordinate;
            DirectionFace direction;

            switch (face) {
                case EAST:
                    coordinate = new Coordinate(9, 1);
                    direction = DirectionFace.SOUTH;
                    break;
                case WEST:
                    coordinate = new Coordinate(0, 1);
                    direction = DirectionFace.SOUTH;
                    break;
                case NORTH:
                    coordinate = new Coordinate(1, 0);
                    direction = DirectionFace.EAST;
                    break;
                case SOUTH:
                    coordinate = new Coordinate(1, 9);
                    direction = DirectionFace.EAST;
                    break;
                default:
                    throw new IllegalStateException();
            }

            while (true) {

                //System.out.println("Current coordinate: " + coordinate.toString());

                grid.put(coordinate, temperature);

                coordinate = coordinate.getRelative(direction);

                if ((direction == DirectionFace.SOUTH && coordinate.y >= 9)
                        || (direction == DirectionFace.EAST && coordinate.x >= 9))
                    break;

            }

        }

        final double interiorTemperature = Double.valueOf(prompt(displayFrame, "Enter initial interior cells temperature:"));

        System.out.println("Interior Temperature: " + interiorTemperature);

        for (int x = 1; x <= 8; x++)
            for (int y = 1; y <= 8; y++)
                grid.put(new Coordinate(x, y), interiorTemperature);


        //endregion

        displayFrame.repaint();

        final int numberOfMinutes = Integer.valueOf(prompt(displayFrame, "Enter number of minutes:"));
        System.out.println("Number of minutes: " + numberOfMinutes);

        for (int minute = 1; minute <= (numberOfMinutes); minute++) {

            //System.out.println("---- Minute " + minute + " ----");

            //Clone the existing grid.
            Map<Coordinate, Double> newGrid = new HashMap<>(grid);

            for (int x = 1; x <= 8; x++) {
                for (int y = 1; y <= 8; y++) {

                    Coordinate coordinate = new Coordinate(x, y);

                    //System.out.println("Checking " + coordinate);

                    double surroundingSum = 0;

                    for (DirectionFace face : directionFaces) {
                        //System.out.println("Fetching temperature for " + coordinate.getRelative(face));
                        surroundingSum += this.grid.get(coordinate.getRelative(face));
                    }

                    double newTemperature = (surroundingSum / directionFaces.length);

                    //System.out.println("Setting " + coordinate + " as " + newTemperature);

                    newGrid.put(coordinate, newTemperature);

                }
            }

            this.grid = newGrid;
            displayFrame.repaint();

        }

        final int xCoordinate = Integer.valueOf(prompt(displayFrame, "Enter x-coordinate:"));

        final int yCoordinate = Integer.valueOf(prompt(displayFrame, "Enter y-coordinate:"));

        Coordinate testCoordinate = new Coordinate(xCoordinate, yCoordinate);

        final double temperature = grid.get(testCoordinate);

        System.out.println("The temperature of cell " + testCoordinate + " is " + temperature);
        JOptionPane.showMessageDialog(displayFrame, "The temperature of cell " + testCoordinate + " is " + temperature);

    }

    public static void main(String[] args) {
        new HeyWhyDontTheyLookCold();
    }

    private static String prompt(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

}

class RenderPanel extends JPanel {

    private final HeyWhyDontTheyLookCold instance;

    RenderPanel(HeyWhyDontTheyLookCold instance) {
        this.instance = instance;
    }

    @Override
    protected void paintComponent(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;

        FontMetrics fontMetrics = g.getFontMetrics();

        for (Map.Entry<Coordinate, Double> en : this.instance.grid.entrySet()) {

            int drawX = (en.getKey().x * HeyWhyDontTheyLookCold.RENDER_SCALE);
            int drawY = (en.getKey().y * HeyWhyDontTheyLookCold.RENDER_SCALE);
            int width = (HeyWhyDontTheyLookCold.RENDER_SCALE - 5);
            int height = (HeyWhyDontTheyLookCold.RENDER_SCALE - 5);

            g.setColor(Color.GRAY);
            g.drawRect(drawX, drawY, width, height);

            String str = String.valueOf((double) Math.round(en.getValue() * 100) / 100);

            //int strWidth = fontMetrics.stringWidth(str);

            g.setColor(Color.BLACK);
            g.drawString(str, ((drawX + 3)), drawY + fontMetrics.getHeight());

        }

        g.dispose();

    }

}

class Coordinate {
    public final int x, y;

    public Coordinate(int x, int y) {

        //Add some bounds
        if (x < 0 || x >= HeyWhyDontTheyLookCold.GRID_MAX_X || y < 0 || y >= HeyWhyDontTheyLookCold.GRID_MAX_Y)
            throw new IllegalArgumentException("Invalid coordinate (" + x + ", " + y + ")");

        this.x = x;
        this.y = y;
    }

    public Coordinate getRelative(DirectionFace face) {
        return new Coordinate(this.x + face.modX, this.y + face.modY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

}
