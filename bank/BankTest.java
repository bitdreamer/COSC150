package bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest
{

   @Test
   public void test()
   {
      Bank b = new Bank();
      Customer alice = b.addCustomer("Alice");
      Customer bob   = b.addCustomer("Bob");
      
      Account aliceSave  = alice.addSavingsAccount();
      Account aliceCheck = alice.addCheckingAccount();
      aliceSave.deposit(1100);
      aliceCheck.deposit(100);
      aliceCheck.withdrawal(10);
      aliceSave.withdrawal(200);
      aliceCheck.withdrawal(10);
      
      Account bobSave = bob.addSavingsAccount();
      bobSave.deposit(500);
      bobSave.withdrawal(10);
      bobSave.withdrawal(10);
      bobSave.withdrawal(10);
      
      assertTrue("min balance on check withdrawal", aliceCheck.balance == 80.0);
      assertTrue("saving withdrawal count",bobSave.balance==470.0);
      
      b.report();

   }

}
