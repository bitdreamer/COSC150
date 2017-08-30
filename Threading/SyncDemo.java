// SyncDemo.java
// This demo's the word "synchronized".  This object has a 
// balance (like a bank amount) and we run two threads to
// add money i.e., deposit().  The deposit() method has a
// delay in it to encourage the system to run both 
// calls concurrently (when one delays, it tried to make
// progress doing the other).  Concurrent calls cause an 
// error in balance.  To avoid the problem, add "synchronized"
// where shown, so that only ONE call to deposit() can run
// at a time.

package Threading;

public class SyncDemo
{
   double balance;
   
   public static void main (String[] args )
   {
	   new SyncDemo();
   }
   
   public SyncDemo()
   {
	   balance = 500; // start with this much money
	    
	   // two transactions should add $250 to balance.
	   // anonymous Runnables are defined to just call deposit() with amount
	   Thread t1 = new Thread
				       ( new Runnable() {
				    	                   public void run() 
				    	                   { deposit(100); }
				    		            }
				       );
	   Thread t2 = new Thread
				       ( new Runnable() {
				    	                   public void run() 
				    	                   { deposit(150); }
				    		            }
				       );
	   t1.start(); // and run them
	   t2.start();
	   
	   // sleep so that both transactions have time to complete
	   try { Thread.sleep(3000); } catch (Exception e) {System.out.println("insomnia");}
	   
	   // report balance, oops (unless deposit as "synchronized")
	   System.out.println("balance="+balance);
			   
   }
   
   public 
   synchronized // when in keep deposits from overwriting each other
   void deposit( double amount )
   {
	   double b = balance;
	   
	   b += amount;
	   
	   try { Thread.sleep(1000); } catch (Exception e) {System.out.println("insomnia");}
	   
	   balance = b;
   }
	
	
}
