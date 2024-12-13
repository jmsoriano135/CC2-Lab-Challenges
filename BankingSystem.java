//Soriano, JM P.
//CITCS1N
//Final Challenge No. 5 : Banking System and Online Shopping Cart


import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystem {
    private double balance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem account = new BankingSystem(1000.00); // Initial balance

        System.out.println("Welcome to the Banking System!");
        
        while (true) {
            System.out.print("Enter amount to withdraw (or -1 to exit): ");
            double amount = 0;

            try {
                amount = scanner.nextDouble();
                if (amount == -1) {
                    break; // Exit condition
                }
                account.withdraw(amount);
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.printf("Current balance: %.2f%n", account.getBalance());
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Banking System!");
    }

    public BankingSystem(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return; // Early return for invalid withdrawal amount
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal amount exceeds current balance.");
        }
        balance -= amount;
        System.out.printf("Withdrawal successful! New balance: %.2f%n", balance);
    }

    public double getBalance() {
        return balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
