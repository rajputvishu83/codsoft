import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 1;
        int totalScore = 0;
        int maxAttempts = 5;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\n--- Round " + rounds + " ---");
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            // Guessing loop for the current round
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Guess the number (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score is: " + totalScore);

            // Ask if the player wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();
            if (!userResponse.equals("yes")) {
                playAgain = false;
            }

            rounds++;
        }

        System.out.println("\nGame Over! You played " + (rounds - 1) + " round(s) with a total score of " + totalScore + ".");
        scanner.close();
    }