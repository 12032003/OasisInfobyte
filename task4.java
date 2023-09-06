import java.util.Scanner;

public class task4 {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("Online Examination System");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    if (currentUser != null) {
                        updateProfileAndPassword();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 3:
                    if (currentUser != null) {
                        startExam();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        scanner.nextLine(); // Consume newline character

        // Perform authentication logic here
        // Example: Check against a database of users

        // If authentication is successful, set the current user
        currentUser = new User(username);
        System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
    }

    private static void updateProfileAndPassword() {
        System.out.println("Update Profile and Password");
        System.out.print("Enter your new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter your new password: ");
        scanner.nextLine(); // Consume newline character

        // Update the user's profile and password
        currentUser.setName(newName);

        System.out.println("Profile and password updated successfully.");
    }

    private static void startExam() {
        System.out.println("Starting Exam...");

        // Perform exam logic here
        // Example: Display questions, record answers, etc.

        System.out.println("Exam completed.");
    }

    private static void logout() {
        currentUser = null;
        System.out.println("Logout successful.");
    }
}

class User {
    private String username;
    private String name;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
