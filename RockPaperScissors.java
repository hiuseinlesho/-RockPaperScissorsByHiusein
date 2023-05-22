import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scanner.next();

        if (playerMove.equals("r") || playerMove.equals("rock")) {
            playerMove = ROCK;
        } else if (playerMove.equals("p") || playerMove.equals("paper")) {
            playerMove = PAPER;
        } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
            playerMove = SCISSORS;
        } else {
            System.out.println("Invalid option. Try again...");
            return;
        }
        Random random = new Random();
        int computerRandomNumber = random.nextInt(3);
        String computerMove = "";

        switch (computerRandomNumber) {
            case 0:
                computerMove = ROCK;
                break;
            case 1:
                computerMove = PAPER;
                break;
            case 2:
                computerMove = SCISSORS;
                break;
        }

        System.out.printf("The computer choose %s.%n", computerMove);

        if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS))
                || (playerMove.equals(PAPER) && computerMove.equals(ROCK))
            || (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))) {
            System.out.println("You win.");
        } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER))
                || (playerMove.equals(PAPER) && computerMove.equals(SCISSORS))
                || (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
            System.out.println("You lose.");
        } else  {
            System.out.println("This game was a draw.");
        }
    }
}
