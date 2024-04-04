import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposit successful!.Current balance: " + balance);
    }

    public void withdraw(double amount) 
    {
        if (balance >= amount) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
        else 
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

public class ATM 
{
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() 
    {
        System.out.println("Select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction()
     {
        while (true)
         {
            displayOptions();
            int choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) 
    {
        BankAccount userAccount = new BankAccount(1000); // Initial balance 
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
