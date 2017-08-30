package ssdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerfectSquares {

	@Test
	public void test() {
		final double DELTA = 1e-15;

		StingySlot test = new StingySlot(); 
		int a[] = new int[5];
  		a[0] = 9; 
  		a[1] = 7; 
  		a[2] = 11; 
  		a[3] = 5; 
  		a[4] = 3; 
 		
		test.setSpin(a); 
		
		double output = test.payoff(); 
		
	    assertEquals(.1, output, DELTA);	}

}
