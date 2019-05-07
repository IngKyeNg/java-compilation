package bank;
import java.util.Scanner;

public class Account {
    double Balance;
    static float InterestRate=0.04F;
    static int Count=0;
    // Static Block
    static {
        Scanner sc = new Scanner(System.in);
        System.out.print("Interest Rate>>");
        InterestRate = Float.parseFloat(sc.nextLine());
    }
    //Non-Static Block
    {
        Count++;
    }
    public Account(double initAmount) {
        Balance = initAmount;
    }
    public Account() {
        this(0.0);
    }
    void Withdraw(double amt){
        Balance -= amt;
    }
    void Deposit(double amt){
        Balance += amt;
    }
    void Update(){
        Balance *= (1.0 + InterestRate);
    }
    static void PurgeInactiveAccounts(){
        //The mehods go here
    }
}
