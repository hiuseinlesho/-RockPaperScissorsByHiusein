import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!%n", name);
        System.out.println("Let's play!");
        System.out.println();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scanner.next();

        while (playerScore < 5 && computerScore < 5) {
            if (playerMove.equals("r") || playerMove.equals("rock")) {
                playerMove = ROCK;
            } else if (playerMove.equals("p") || playerMove.equals("paper")) {
                playerMove = PAPER;
            } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
                playerMove = SCISSORS;
            } else {
                System.out.println("Invalid option. Try again...");
                playerMove = scanner.nextLine();
                continue;
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
                playerScore++;
            } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER))
                    || (playerMove.equals(PAPER) && computerMove.equals(SCISSORS))
                    || (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
                System.out.println("You lose.");
                computerScore++;
            } else  {
                System.out.println("This game was a draw.");
                playerScore++;
                computerScore++;
            }
            System.out.printf("%s score = %d%n", name, playerScore);
            System.out.printf("Computer score = %d", computerScore);
            System.out.println();
            if (playerScore == 5 || computerScore == 5) {
                break;
            }
            playerMove = scanner.next();
        }
        System.out.println();
        if (playerScore > computerScore) {
            System.out.printf("The winner is %s! :)%n", name);
            System.out.printf("Result is %d>%d", playerScore, computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("The winner is computer! :(%n");
            System.out.printf("Result is %d>%d", computerScore, playerScore);
        } else {
            System.out.println("Draw! :|");
        }
    }
}
