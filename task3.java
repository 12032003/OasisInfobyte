import java.util.Scanner;

public class task3 {
    private static Scanner scanner = new Scanner(System.in);
    private static ATM atm = new ATM();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("ATM Interface");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    atm.showTransactionsHistory();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter the recipient's account number: ");
                    String recipientAccountNumber = scanner.nextLine();
                    System.out.print("Enter the transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    atm.transfer(recipientAccountNumber, transferAmount);
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
}

class ATM {
    private double balance = 1000.0;
    private StringBuilder transactionsHistory = new StringBuilder();

    public void showTransactionsHistory() {
        System.out.println("Transactions History:");
        System.out.println(transactionsHistory.toString());
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionsHistory.append("Withdraw: -$").append(amount).append("\n");
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionsHistory.append("Deposit: +$").append(amount).append("\n");
        System.out.println("Deposit successful. Current balance: $" + balance);
    }

    public void transfer(String recipientAccountNumber, double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionsHistory.append("Transfer to ").append(recipientAccountNumber).append(": -$").append(amount).append("\n");
            System.out.println("Transfer successful. Current balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
