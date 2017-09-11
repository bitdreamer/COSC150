package bank;

public class Account
{
   protected int id;
   protected double balance;
   static protected int maxid = 0;
   
   // construtor, assigns next id
   public Account()
   {
      balance = 0;
      id = ++maxid;
   }

   // just add the money
   public void deposit( double amount )
   {
      balance += amount;
   }
   
   // just take out the money, don't adjust for anything
   public void withdrawal( double amount )
   {
      balance -= amount;
   }
   
   public String accountType(){ return "dk"; }
   
   // tell about this account
   public void report()
   {
      System.out.println("  account "+ id + " of type "+accountType()+" has balance = " + balance );
   }

}
