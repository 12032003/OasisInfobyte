import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int number = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        int score = 0;
        System.out.println("Guess the number between " + min + " and " + max + ". You have 5 attempts to guess it.");
        while (attempts < 5) {
            int guess = scanner.nextInt();
            attempts++;
            if (guess == number) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                score += 10;
                break;
            } else if (guess < number) {
                System.out.println("Your guess is lower than the number.");
            } else {
                System.out.println("Your guess is higher than the number.");
            }
        }
        scanner.close(); // close the scanner object
        if (attempts == 5) {
            System.out.println("Game over! The number was " + number + ".");
        }
        System.out.println("Your score is " + score + ".");
    }
}
