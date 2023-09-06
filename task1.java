import java.util.*;

class User {
    String loginId;
    String password;

    User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}

class Reservation {
    String passengerName;
    int trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;

    Reservation(String passengerName, int trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }
}

public class task1 {
    static Map<String, User> users = new HashMap<>();
    static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Login
            System.out.println("Enter your login ID: ");
            String loginId = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            // Check if the login credentials are valid
            User user = users.get(loginId);
            if (user == null ||!user.password.equals(password)) {
                System.out.println("Invalid login credentials.");
                return;
            }

            System.out.println("Login successful!");

            // Reservation
            System.out.println("Enter your name: ");
            String passengerName = scanner.nextLine();
            System.out.println("Enter the train number: ");
            int trainNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            System.out.println("Enter the train name: ");
            String trainName = scanner.nextLine();
            System.out.println("Enter the class type: ");
            String classType = scanner.nextLine();
            System.out.println("Enter the date of journey: ");
            String dateOfJourney = scanner.nextLine();
            System.out.println("Enter the source station: ");
            String from = scanner.nextLine();
            System.out.println("Enter the destination station: ");
            String to = scanner.nextLine();

            // Create and store the reservation
            Reservation reservation = new Reservation(passengerName, trainNumber, trainName, classType, dateOfJourney, from, to);
            reservations.put(loginId, reservation);

            System.out.println("Reservation successful!");

            // Cancellation
            System.out.println("Do you want to cancel the reservation? (yes/no)");
            String cancel = scanner.nextLine();
            if (cancel.equalsIgnoreCase("yes")) {
                reservations.remove(loginId);
                System.out.println("Reservation cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
