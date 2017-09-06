package bank;

public class Account
{
   protected int id;
   protected double balance;
   static protected int maxid = 0;
   
   
   public Account()
   {
      balance = 0;
      id = ++maxid;
   }

   public void report()
   {
      System.out.println("  account "+ id + " of type "+accountType()+" has balance = " + balance );
   }
   
   public void deposit( double amount )
   {
      balance += amount;
   }
   
   public void withdrawal( double amount )
   {
      balance -= amount;
   }
   
   public String accountType(){ return "dk"; }
}
