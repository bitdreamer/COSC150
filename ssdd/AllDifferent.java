package ssdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllDifferent {

	@Test
	public void test() {
		final double DELTA = 1e-15;

		StingySlot test = new StingySlot(); 
		int a[] = new int[5];
  		a[0] = 11; 
  		a[1] = 7; 
  		a[2] = 5; 
  		a[3] = 3; 
  		a[4] = 19; 
 		
		test.setSpin(a); 
		
		double output = test.payoff(); 
		
	    assertEquals(0, output, DELTA);	}

}
