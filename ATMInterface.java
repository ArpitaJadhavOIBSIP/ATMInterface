import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //user ID
        System.out.println("Enter your ID: ");
        String ID = sc.next();

        //pin
        System.out.println("Enter yor pin: ");
        int pin = sc.nextInt();

        //user's balance
        int balance = 200000;
        //int amount = sc.nextInt();
        //int depositAmount = sc.nextInt();

        while (true){
            System.out.println("1. Check Balance");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposit");
            System.out.println("4.Transfer");
            System.out.println("5.Quit");

            int c = sc.nextInt();
            switch (c){
                case 1:
                    checkBalance(balance);
                    break;
                case 2:
                    int withdrawAmount = 0;
                    withdraw(balance,withdrawAmount);
                    break;
                case 3:
                    int depositAmount = 0;
                    deposit(balance,depositAmount);
                    break;
                case 4:
                    transfer(balance);
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        //System.out.println("Account balance is: "+ balance);
        //int amount = sc.nextInt();
        //int depositAmount = sc.nextInt();


    }

    public static void checkBalance(int balance) {
        System.out.println("Your balance is : "+ balance);
    }

    private static void transfer(int balance) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Receipent's name : ");
        String receipent = sc.nextLine();
        System.out.println("Enter transfer amount : ");
        int transferAmount = sc.nextInt();
        try{
            if (balance >= transferAmount){
                if (transferAmount <= 20000){
                    balance = balance - transferAmount;
                    System.out.println("Successfully transfered...");
                    System.out.println(transferAmount + " Rs. transferred to " + receipent);
                }
                else{
                    System.out.println("Sorry!! Amount limit is 20000");
                }
            }else {
                System.out.println("Insufficient balance");
            }
        }catch (Exception e){

        }
    }


    static void withdraw(int balance, int withdrawAmount){
        System.out.println("Enter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        withdrawAmount = sc.nextInt();
        if (withdrawAmount>balance){
            System.out.println("insufficient balance");
        }else {
            balance = balance-withdrawAmount;
            System.out.println("Amount is withdraw successfully. Your account balance is "+ balance);
        }

    }
    static void deposit(int balance, int depositAmount){
        System.out.println("Enter amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        depositAmount = sc.nextInt();
        balance = balance + depositAmount;
        System.out.println("Amount is deposit successfully. Your account balance is "+ balance);
    }
    static void quit(){
        System.out.println("Thank you for using ATM :).");
        System.exit(0);
    }

}
