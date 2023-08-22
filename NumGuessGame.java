import java.util.Random;
import java.util.Scanner;

public class NumGuessGame 
{
    public static void main(String[] args) 
{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int maxAttempts = 5;
        int attempts = 0;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a random number between 1 and 100 (inclusive).");
        System.out.println("Can you guess it within " + maxAttempts + " attempts?");

        while (attempts < maxAttempts) 
	{
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) 
	    {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                int score = calculateScore(maxAttempts, attempts);
                System.out.println("Your score: " + score);
                break;
            } 
		else if (userGuess < targetNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        if (attempts == maxAttempts) 
	{
            System.out.println("Sorry, you ran out of attempts. The number was " + targetNumber + ".");
            System.out.println("Better luck next time!");
        }
    }

    private static int calculateScore(int maxAttempts, int attempts) 
    {
        int maxScore = 1000;     // Max score achievable
        double scorePerAttempt = (double) maxScore / maxAttempts;
        return (int) (maxScore - (scorePerAttempt * (attempts - 1)));
    }
}
