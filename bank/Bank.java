// Bank.java
// 2017 fall COSC-150
// This is the top level class for bank teller ....

package bank;

import java.util.*;

public class Bank
{
   protected LinkedList<Customer> customers;
   
   // Just exercise the Bank class a little
   public static void main( String[] args )
   {
      Bank b = new Bank();
      
   }
      
   // constructor
   public Bank()
   {
      customers = new LinkedList<Customer>();
      
   }
   
   // add a new bank customer with this name
   public Customer addCustomer( String name )
   {
      Customer c = new Customer( name );
      customers.add( c );
      return c;
   }
   
   public void report()
   {
      System.out.println("Here's the people the bank has ... ");
      Iterator<Customer> it = customers.iterator();
      while ( it.hasNext() )
      {
         Customer c = it.next();
         c.report();
      }
   }

}
