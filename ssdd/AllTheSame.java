package ssdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllTheSame {

	@Test
	public void test() {
		final double DELTA = 1e-15;

		StingySlot test = new StingySlot(); 
		int a[] = new int[5];
  		a[0] = 5; 
  		a[1] = 5; 
  		a[2] = 5; 
  		a[3] = 5; 
  		a[4] = 5; 
 		
		test.setSpin(a); 
		
		double output = test.payoff(); 
		
	    assertEquals(1000000.0, output, DELTA);	}

}
