import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadderGame {
    static final int WINNING_POSITION = 100;

    static Map<Integer, Integer> snakes = new HashMap<>();
    static Map<Integer, Integer> ladders = new HashMap<>();

    static {
        // Define snakes
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);
        
        // Define ladders
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Position = 0, player2Position = 0;
        boolean player1Turn = true;

        System.out.println("Welcome to Snake and Ladder Game!");
        System.out.println("Player 1 and Player 2, get ready!");

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            System.out.println("\n" + (player1Turn ? "Player 1's turn" : "Player 2's turn"));
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();

            int diceRoll = random.nextInt(6) + 1;
            System.out.println("You rolled a " + diceRoll);

            if (player1Turn) {
                player1Position = movePlayer(player1Position, diceRoll);
                System.out.println("Player 1 is now at position: " + player1Position);
            } else {
                player2Position = movePlayer(player2Position, diceRoll);
                System.out.println("Player 2 is now at position: " + player2Position);
            }

            if (player1Position >= WINNING_POSITION) {
                System.out.println("Congratulations! Player 1 wins!");
                break;
            } else if (player2Position >= WINNING_POSITION) {
                System.out.println("Congratulations! Player 2 wins!");
                break;
            }

            player1Turn = !player1Turn;
        }
        scanner.close();
    }

    private static int movePlayer(int position, int diceRoll) {
        position += diceRoll;

        if (snakes.containsKey(position)) {
            System.out.println("Oops! Bitten by a snake! Sliding down...");
            position = snakes.get(position);
        } else if (ladders.containsKey(position)) {
            System.out.println("Yay! Climbing up a ladder!");
            position = ladders.get(position);
        }

        return position;
    }
}

// Save this file as SnakeLadderGame.java
// Compile: javac SnakeLadderGame.java
// Run: java SnakeLadderGame

// Let me know if you want any improvements or extra features! 🚀
