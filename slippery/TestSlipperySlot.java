// TestSlipperySlot.java

package slippery;

import static org.junit.Assert.*;
import org.junit.*;

public class TestSlipperySlot {
	
	SlipperySlot ss;
	
	@Before
	public void beforeClass()
	{
		ss = new SlipperySlot();
	}
	
	@Test
	public void test1()
	{
		int[] m = {5,5,5,5,5};
		int po = ss.payOff(m);
		assertTrue("big win", po==1000000 ); 
	}
	
	@Test
	public void test2()
	{
		int[] m = {4,4,4,4,0};
		int po = ss.payOff(m);
		assertTrue("big win", po==10010 ); 
	}
}
