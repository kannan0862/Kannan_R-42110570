package bank.services;

import bank.entities.BankAccount;
import java.util.Scanner;
import java.util.HashMap;

public class BankManagementSystem {
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private static int accountCounter = 1001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    viewAccountDetails(scanner);
                    break;
                case 3:
                    depositMoney(scanner);
                    break;
                case 4:
                    withdrawMoney(scanner);
                    break;
                case 5:
                    checkBalance(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter Account Holder Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit Amount: ");
        double initialDeposit = scanner.nextDouble();

        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative. Account creation failed.");
            return;
        }

        BankAccount account = new BankAccount(name, accountCounter, initialDeposit);
        accounts.put(accountCounter, account);
        System.out.println("Account created successfully. Your Account Number is: " + accountCounter);
        accountCounter++;
    }

    private static void viewAccountDetails(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println("Current Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
