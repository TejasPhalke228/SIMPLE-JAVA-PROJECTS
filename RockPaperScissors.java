import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rps = {"rock", "paper", "scissors"};
        String computerMove;
        String playerMove;
        
        while (true) {
            System.out.print("Enter move (rock, paper, scissors). To exit the game, type 'exit': ");
            playerMove = scanner.nextLine().toLowerCase();
            
            if (playerMove.equals("exit")) {
                break;
            }
            
            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int randomIndex = new Random().nextInt(rps.length);
            computerMove = rps[randomIndex];
            	
            System.out.println("Computer move: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (playerWins(playerMove, computerMove)) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }
        
        scanner.close();
    }

    public static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    public static boolean playerWins(String playerMove, String computerMove) {
        return (playerMove.equals("rock") && computerMove.equals("scissors")) ||
               (playerMove.equals("paper") && computerMove.equals("rock")) ||
               (playerMove.equals("scissors") && computerMove.equals("paper"));
    }
}