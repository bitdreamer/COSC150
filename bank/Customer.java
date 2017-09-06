package bank;

import java.util.*;

public class Customer
{
   protected String name;
   protected LinkedList<Account> listOfAccounts;
   
   public static void main( String[] args )
   {
      Customer jane = new Customer("Jane");
      
      jane.report();
      //jane.deposit(5);
      
   }
   public CheckingAccount addCheckingAccount()
   {
      CheckingAccount ca = new CheckingAccount();
      listOfAccounts.add( ca );
      return ca;
   }
   
   public SavingsAccount addSavingsAccount()
   {
      SavingsAccount sa = new SavingsAccount();
      listOfAccounts.add(sa);
      return sa;
   }
   
   public void testStuff()
   {
      CheckingAccount ca = new CheckingAccount();
      listOfAccounts.add( ca );
      ca.deposit(100);
      ca.withdrawal(10);
      
      SavingsAccount sa = new SavingsAccount();
      listOfAccounts.add(sa);
      sa.deposit(2000);
      ca.withdrawal(10);
      sa.withdrawal(100);
      sa.withdrawal(100);
      sa.withdrawal(100);
      
      ca.withdrawal(500);
      
   }
   
   public Customer( String n )
   {
      name = n;
      listOfAccounts = new LinkedList<Account>();


   }
   
   // tell everything about a Customer
   public void report()
   {
      System.out.println("Customer "+name+" has accounts ....");
      Iterator<Account> it = listOfAccounts.iterator(); 
      while ( it.hasNext() )
      {
         Account a = it.next();
         a.report();
      }
      
   }
   
}
