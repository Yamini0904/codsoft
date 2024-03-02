import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;

        Random rand = new Random();

        int targetNumber = rand.nextInt(101);

        Scanner scanner = new Scanner(System.in);

        int userGuess;
        boolean correctGuess = false;

        System.out.println("Welcome to the Number game!");
        System.out.println("Try to guess the number between " + minNumber + " and " + maxNumber);

        while (!correctGuess) {
            System.out.print("Enter the number you guessed: ");
            userGuess = scanner.nextInt();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number!!");
                correctGuess = true;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        scanner.close();
    }
}
