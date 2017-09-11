package bank;

import java.util.*;

public class Customer
{
   protected String name;
   protected LinkedList<Account> listOfAccounts;
   
   // constructor, argument is the person's name
   public Customer( String n )
   {
      name = n;
      listOfAccounts = new LinkedList<Account>();
   }
   
   // make a new checking account for this customer
   public CheckingAccount addCheckingAccount()
   {
      CheckingAccount ca = new CheckingAccount();
      listOfAccounts.add( ca );
      return ca;
   }
   
   // make a new savings account for this customer
   public SavingsAccount addSavingsAccount()
   {
      SavingsAccount sa = new SavingsAccount();
      listOfAccounts.add(sa);
      return sa;
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
