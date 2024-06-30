import java.util.Scanner;

public class ATM_Interface {
    private BankAccount account;
    private Scanner scanner;

    public ATM_Interface(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Goodbye!");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        displayMenu(); // Recursive call to display menu again
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    private void deposit(double amount) {
        account.deposit(amount);
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM_Interface atm = new ATM_Interface(userAccount);
        atm.displayMenu();
    }
}
