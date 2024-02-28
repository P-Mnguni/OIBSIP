package ATM;

import java.util.Scanner;

public class BankAccount {

    String customerName;
    String customerAccNo;
    String accPassword;
    float accBalance = 20000;
    int transactions = 0;
    String transHistory = "";
    Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.print("Enter your name (Full names and Surname) : ");
        this.customerName = sc.nextLine();
        System.out.print("\nEnter your account number : ");
        this.customerAccNo = sc.nextLine();
        System.out.print("\nEnter a password : ");
        this.accPassword = sc.nextLine();
        System.out.print("\nAccount Registration Successful\n");
    }

    public boolean login() {
        boolean isLogin = false;
        String custName;
        String password;

        while ( !isLogin ) {
            System.out.print("\nEnter your name : ");
            custName = sc.nextLine();
            if (this.customerName == custName) {
                System.out.print("\nEnter your password : ");
                password = sc.nextLine();
                if (this.accPassword == password) {
                    System.out.print("\nLogin successful\n");
                    isLogin = true;
                }
                else {
                    System.out.print("Incorrect password!!!");
                }
            }
            else {
                System.out.print("User not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {

        System.out.print("\nEnter the amount : ");
        float withdrawn = sc.nextFloat();

        try {
            if (accBalance >= withdrawn) {
                transactions++;
                accBalance -= withdrawn;
                System.out.println("\nWithdraw Successful");
                String str = "R" + withdrawn + " Withdrawn\n";
                transHistory = transHistory.concat(str);
            }
            else {
                System.out.println("\nInsufficient amount in the account");
            }
        }
        catch ( Exception e ) {
        }
    }

    public void deposit() {

        System.out.print("\nEnter the amount : ");
        float deposited = sc.nextFloat();
    
        try {
            if ( deposited <= 5000 ) {
                transactions++;
                accBalance += deposited;
                System.out.println("\nDeposit Successful");
                String str = "R" + deposited + " Deposited\n";
                transHistory = transHistory.concat(str);
            }
            else {
                System.out.println("\nSorry...Limit reached");
            }
        }
        catch ( Exception e ) {
        }
    }

    public void transfer() {

        
        System.out.print("\nEnter Receipent's Account Number : ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter Amount : ");
        float amount = sc.nextFloat();
    
        try {
            if ( accBalance >= amount ) {
                if ( amount <= 50000 ) {
                    transactions++;
                    accBalance -= amount;
                    System.out.println("\nTransfer Successful");
                    String str = "R" + amount + " transfered to " + receipent + "\n";
                    transHistory = transHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry. Limit is reached");
                }
            }
            else {
                System.out.println("\nInsufficient Balance in the account");
            }
        }
        catch ( Exception e ) {
        }
    }
        
    public void checkBalance() {
        System.out.println("\n" + "R" + accBalance);
    }
    
    public void transHistory() {
        if ( transactions == 0 ) {
            System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + transHistory);
        }
    }

    
}
    


