package year2016;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h3>Drinking Problem</h3>
 * <p>Bob has a drinking problem...not that kind of a problem.
 * Bob drinks Gatorade, but he likes to have several glasses of Gatorade in front of him.
 * He also has developed the problem that he must drink from the fullest glass,
 * and must drink 1/4 of the content of the glass. He always drinks a whole number of ounces of Gatorade.
 * If 1/4 of the glass is not an whole number of ounces, he will drink
 * a little more to make it an whole number of ounces.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2016">Problem Descrption and Requirements</a>
 */
public class DrinkingProblem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //"Only valid positive integer values will be entered."
        //Let's be lazy and not check the inputs.
        //Finalize the inputs to prevent modification. Not like it's going to happen but I feel like it.

        System.out.println("How many glasses are there?: ");
        final int glassAmount = scanner.nextInt();

        //Yes, I know the inputs are whole numbers.
        //Using doubles to prevent some auto-flooring
        Map<Integer, Double> glassOzAmountMap = new HashMap<>();

        for (int i = 1; i <= glassAmount; i++) {
            System.out.println("How many oz in glass " + i + "?: ");
            glassOzAmountMap.put(i, scanner.nextDouble());
        }

        System.out.println("How thirsty is Bob?: ");
        final int bobsOzThirst = scanner.nextInt();

        int bobsOzConsumption = 0;
        int drinkCount = 0;

        while (bobsOzConsumption < bobsOzThirst) {

            //"He must drink from the fullest glass"
            Map.Entry<Integer, Double> fullestDrink = Collections.max(glassOzAmountMap.entrySet(), Map.Entry.comparingByValue());

            //"drink 1/4 of the content of the glass"
            //"he will drink a little more to make it an whole number of ounces."
            int ozToDrink = (int) Math.ceil((fullestDrink.getValue() / 4));

            bobsOzConsumption += ozToDrink;

            fullestDrink.setValue((fullestDrink.getValue() - ozToDrink));

            glassOzAmountMap.put(fullestDrink.getKey(), fullestDrink.getValue());

            drinkCount++;
            System.out.print("Drink " + drinkCount + ": " + ozToDrink + " oz from glass " + fullestDrink.getKey() + " | ");

            for (Double v : glassOzAmountMap.values())
                System.out.print(v.intValue() + " ");


            System.out.println();
        }

        System.out.println("Drank: " + bobsOzConsumption + " oz");
        System.out.println("It took Bob " + drinkCount + " drink" + (drinkCount == 1 ? "" : "s") + " to satisfy his thirst");

        scanner.close();

    }

}
