import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 5; // Adjust the number of attempts as needed
        int totalAttempts = 0;
        int roundsWon = 0;
        char playAgain;

        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;

            System.out.println("Guess a number between " + min + " and " + max + ". You have " + maxAttempts + " attempts:");

            while (attempts < maxAttempts) {
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    roundsWon++;
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts! The correct number was: " + randomNumber);
                }
            }

            System.out.println("Do you want to play again? (Y/N)");
            scanner.nextLine(); // Consume the newline left by nextInt()
            playAgain = scanner.nextLine().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        // Calculate and display the user's score
        double score = (double) roundsWon / totalAttempts * 100;
        System.out.println("Game over! Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.printf("Your score: %.2f%%\n", score);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
