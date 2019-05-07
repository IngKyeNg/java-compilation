package bank;

public class Bank {
  
  public static void main2(String[] args) {
    System.out.printf("The current rate is %.2f%n",Account.InterestRate);
    Account acc1 = new Account(1000);
    Account acc2 = new Account();
    Account acc3 = new Account("Alibaba");
    
    System.out.println("No of Account objects created is " + Account.Count);
    
    //acc1.Withdraw(200);
    acc2.Deposit(100);
    //acc1.InterestRate = 0.05F;
    Account.InterestRate = 0.05F;
    acc2.Update();
    System.out.printf("The Balance is $%.2f%n",acc2.Balance);
    Account.PurgeInactiveAccounts();
  }
  
  public static void main(String[] args) {
    double loanAmount=1_000_000;
    float annualRate = 0.046F;
    int durationInYears = 30;
    
    double monthlyInstallment = 
        Financial.Pmt(loanAmount, annualRate/12, durationInYears*12);
    
    System.out.printf("Monthly Installment is $%.2f %n", monthlyInstallment);
    System.out.printf("Total Payment is $%.2f %n", 
        monthlyInstallment*durationInYears*12);
  }
  
}  
  
  