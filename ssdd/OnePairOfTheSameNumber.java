package ssdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class OnePairOfTheSameNumber {

	@Test
	public void test() {
		final double DELTA = 1e-15;

		StingySlot test = new StingySlot(); 
		int a[] = new int[5];
  		a[0] = 5; 
  		a[1] = 5; 
  		a[2] = 3; 
  		a[3] = 2; 
  		a[4] = 7; 
 		
		test.setSpin(a); 
		
		double output = test.payoff(); 
		
	    assertEquals(2.0, output, DELTA);	}

}
