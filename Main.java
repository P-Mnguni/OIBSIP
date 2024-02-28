package ATM;

//import ATM.BankAccount;
import java.util.Scanner;

public class Main {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        try (Scanner sc = new Scanner(System.in)) {
            while ( !flag ) {
                try {
                    input = sc.nextInt();
                    flag = true;

                    if ( flag && input > limit || input < 1 ) {
                        System.out.println("Choose the number between 1 and " + limit);
                        flag = false;
                    }
                }
                catch ( Exception e ) {
                    System.out.println("Enter only integer value");
                    flag = false;
                }
            }
        }

        return input;
    }
    public static void main(String[] args) {
        System.out.println("\nWelcome to PK Bank *\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter your choice : ");
        int choice = takeIntegerInput(2);
    
        if ( choice == 1 ) {
            BankAccount acc = new BankAccount();
            acc.register();
            while ( true ) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter your choice : ");
                int ch = takeIntegerInput(2);
                if ( ch == 1 ) {
                    if ( acc.login() ) {
                        System.out.println("\n\n**WELCOME BACK " + acc.customerName + " **\n");
                        boolean isFinished = false;
                        while ( !isFinished ) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Balance \5.Transaction History \6.Exit");
                            System.out.print("\nEnter your choice : ");
                            int c = takeIntegerInput(6);
                            switch(c) {
                                case 1:
                                    acc.withdraw();
                                    break;
                                case 2:
                                    acc.deposit();
                                    break;
                                case 3:
                                    acc.transfer();
                                    break;
                                case 4:
                                    acc.transfer();
                                    break;
                                case 5:
                                    acc.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}