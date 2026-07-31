import java.util.Scanner;
public class BankManagementSystem
{
    static Scanner sc = new Scanner(System.in);
    static String accountHolder = "";
    static String accountNumber = "";
    static int pin = 0;
    static double balance = 0;
    static boolean accountCreated = false;
    static void createAccount()
{

        if(accountCreated)
{
            System.out.println("Account already exists.");
            return;
        }

        System.out.println("\n===== CREATE ACCOUNT =====");

        System.out.print("Enter Account Holder Name: ");
        accountHolder = sc.nextLine();

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        System.out.print("Set 4-digit PIN: ");
        pin = sc.nextInt();

        System.out.print("Enter Initial Deposit: ");
        balance = sc.nextDouble();
        sc.nextLine();
        accountCreated = true;
        System.out.println("Account created successfully.");
    }
    static boolean verifyPin()
{

        if (!accountCreated)
{
            System.out.println("Please create an account first.");
            return false;
        }

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
        sc.nextLine();

        if (enteredPin == pin)
{
            return true;
        } else {
            System.out.println("Incorrect PIN.");
            return false;
        }
    }

    static void deposit()
{

        if (verifyPin())
{

            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            if (amount > 0)
{
                balance += amount;
                System.out.println("Deposit Successful.");
                System.out.println("Current Balance: " + balance);
            } else
{
                System.out.println("Invalid Amount.");
            }
        }
    }

    static void withdraw() 
{
        if (verifyPin())
{
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            if (amount <= 0)
{
                System.out.println("Invalid Amount.");
            } else if (amount > balance)
{
                System.out.println("Insufficient Balance.");
            } else
{
                balance -= amount;
                System.out.println("Withdrawal Successful.");
                System.out.println("Remaining Balance: " + balance);
            }
        }
    }
    static void checkBalance()
{

        if (verifyPin())
{
            System.out.println("Current Balance: " + balance);
        }
    }
    static void viewAccountDetails()
{

        if (verifyPin())
{
            System.out.println("\n===== ACCOUNT DETAILS =====");
            System.out.println("Account Holder : " + accountHolder);
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Balance        : " + balance);
        }
    }
    static void changePin()
{
        if (verifyPin())
{
            System.out.print("Enter New PIN: ");
            pin = sc.nextInt();
            sc.nextLine();
            System.out.println("PIN changed
successfully.");
        }
    }
    static void displayMenu()
{
        System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. View Account Details");
        System.out.println("6. Change PIN");
        System.out.println("7. Exit");
        System.out.print("Enter Your Choice: ");
    }
    public static void main(String[] args)
{
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
{
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    viewAccountDetails();
                    break;

                case 6:
                    changePin();
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
            }

        } while (choice != 7);
        sc.close();
    }
}