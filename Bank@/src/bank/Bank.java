package bank;

public class Bank {

    public static void main(String[] args) {
        System.out.printf("The current Interest Rate is %.2f%%%n",
                Account.InterestRate*100);
        Account acc1 = new Account(1000);
        Account acc2 = new Account();
        System.out.printf("The no of records is %d%n",Account.Count);
        acc1.Withdraw(200);
        acc2.Deposit(300);
        acc1.Update();
        acc2.Update();
        
        System.out.printf("The new balance of acc1 is $%.2f%n",acc1.Balance);
        System.out.printf("The new balance of acc2 is $%.2f%n",acc2.Balance);
        System.out.printf("The interest rate of acc1 is %.2f%%%n",acc1.InterestRate*100);
        System.out.printf("The interest rate of acc2 is %.2f%%%n",acc2.InterestRate*100);
    }
    
}
