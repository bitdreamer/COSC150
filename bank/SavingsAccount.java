package bank;

public class SavingsAccount extends Account
{
   protected int numberOfWithdrawals;
   
   public SavingsAccount()
   {
      numberOfWithdrawals = 0;
   }
   
   public String accountType(){ return "savings"; }
   
   

}
