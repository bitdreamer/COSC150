package ssdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class Occuring42 {

	@Test
	public void test() {
		final double DELTA = 1e-15;

		StingySlot test = new StingySlot(); 
		int a[] = new int[5];
  		a[0] = 5; 
  		a[1] = 7; 
  		a[2] = 11; 
  		a[3] = 3; 
  		a[4] = 42; 
 		
		test.setSpin(a); 
		
		double output = test.payoff(); 
		
	    assertEquals(.35, output, DELTA);	}

}
