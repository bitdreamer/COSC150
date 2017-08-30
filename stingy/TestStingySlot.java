// TestSlipperySlot.java

package stingy;

import static org.junit.Assert.*;
import org.junit.*;

public class TestStingySlot {
	
	StingySlot ss;
	
	@Before
	public void beforeClass()
	{
		ss = new StingySlot();
	}
	
	@Test
	public void test1()
	{
		System.out.println("this is the start of a test");
		int[] m = {5,5,5,5,5};
		ss.setSpin(m);
		double po = ss.payoff();
		assertTrue("big win", po==1000000 ); 
	}
	

	@Test
	public void test2()
	{
		int[] m = {4,4,4,4,0};
		ss.setSpin(m);
		double po = ss.payoff();
		assertTrue("big win", po==10000.40 ); 
	}
}
