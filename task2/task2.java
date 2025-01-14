import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3; 
        int totalScore = 0;

        System.out.println("Welcome to 'Guess the Number' Game!");
        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1; 
            int maxAttempts = 10;  
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Try to guess the number between 1 and 100.");
            
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int score = (maxAttempts - attemptsLeft + 1);
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number correctly.");
                    System.out.println("You earned " + score + " points this round.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attemptsLeft--;
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was: " + numberToGuess);
            }
        }
        System.out.println("\nGame over!");
        System.out.println("Your total score is: " + totalScore);
        scanner.close();
    }
}
