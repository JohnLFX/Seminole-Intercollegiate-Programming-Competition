package year2013;

import java.util.Scanner;

/**
 * <h3>You Are It</h3>
 * <p>Kids at a birthday party want to play a favorite game modeled after the game of tag.
 * Unfortunately it is raining so they can’t go outside.
 * They can't run in the house so you decide to write a computer application to simulate the game.
 * In the game the children sit in a circle and one person outside the ring (the leader)
 * sings a song with a fixed number of words. Moving clockwise around the circle,
 * the leader points to a new child in the ring for each word in the song.
 * The child being pointed to on the last word of the song is out and must leave the circle.
 * The leader then repeats the process with the smaller circle.
 * The game continues until the last child is eliminated.
 * This child is then the leader to start the next game.</p>
 *
 * @author John Cameron
 * @see <a href="https://www.seminolestate.edu/computers/competition/samples/2013">Problem Descrption and Requirements</a>
 */
public class YouAreIt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of kids: ");
        final int kidsAmount = scanner.nextInt();

        System.out.println("Enter number of words in song: ");
        final int wordsPerSong = scanner.nextInt();

        scanner.close();

        int kidsInGroup = kidsAmount;//Subtract one to consider the leader

        int index = 0;
        int kidsOut = 0;

        while (kidsInGroup > 0) {

            index += wordsPerSong;

            if (index > kidsInGroup)
                index = index % kidsInGroup;

            System.out.print(index + " ");

            kidsInGroup--;

            //kids = new boolean[kidsAmount - ++kidsOut];

            kidsOut++;

        }


        System.out.println();

    }

}
