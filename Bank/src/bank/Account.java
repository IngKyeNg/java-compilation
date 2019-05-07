package bank;
import java.util.Scanner;

public class Account{
  double Balance;
  static float InterestRate=0.03F;
  static public long Count=0;
  static{//Static block - Class Constructor
    Scanner sc = new Scanner(System.in);
    System.out.print("Intereste Rate>>");
    InterestRate = Float.parseFloat(sc.nextLine());
  }
  {//Non-Static block
    Count++;
  }
  public Account(double initAmount){
    Balance = initAmount;
  }
  public Account(){
    this(0.0);
  }
  public Account(String name){
    Balance = 0;
  }
  public void Deposit(double amt){
    Balance += amt;
  }
  public void Withdraw(double amt){
    assert(amt>0):"amt must be >0";
    assert(Balance>=amt):"Not enough money!";
    
    double oldBalance = Balance;
    Balance -= amt;
    
    assert((Balance+amt)==oldBalance):"Oops! Something wrong here!";
  }
  public void Update(){
    Balance *= (1.0+InterestRate);
  }
  static public void PurgeInactiveAccounts(){//Class wide operation
    //The method goes here....
  }
}
