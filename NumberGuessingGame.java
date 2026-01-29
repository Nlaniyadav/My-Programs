import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {

            System.out.println("\nSelect Difficulty Level:");
            System.out.println("1. Easy   (1 - 50, 7 attempts)");
            System.out.println("2. Medium (1 - 100, 5 attempts)");
            System.out.println("3. Hard   (1 - 200, 4 attempts)");
            System.out.print("Enter choice (1/2/3): ");

            int choice;
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter 1, 2, or 3: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            int maxRange = 100;
            int attempts = 5;

            switch (choice) {
                case 1:
                    maxRange = 50;
                    attempts = 7;
                    break;
                case 2:
                    maxRange = 100;
                    attempts = 5;
                    break;
                case 3:
                    maxRange = 200;
                    attempts = 4;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium.");
                    maxRange = 100;
                    attempts = 5;
            }

            int number = random.nextInt(maxRange) + 1;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and " + maxRange + ".");
            System.out.println("You have " + attempts + " attempts to guess it.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("\nAttempt " + i + " - Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    i--;
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the number!");
                    guessedCorrectly = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou've used all attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nPlay again? (y/n): ");
            char again = scanner.next().toLowerCase().charAt(0);
            playAgain = (again == 'y');
        }

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}
