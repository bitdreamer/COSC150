// ComplexTest.java
// BEK this is to test the Complex class (as in JUnit test)

package testStuff;
import static org.junit.Assert.*;

import org.junit.*;

public class ComplexTest
{
	Complex x;
	Complex y;
	Complex zero;
	
	// start with fresh x and y values for each test
	@Before
	public void before()
	{
		x = new Complex( 3,4 );
		y = new Complex( 5, 12 );
        zero = new Complex(); 
	}
	@Test
	public void testPlusEqualsReal()
	{		
		x.plusEquals( y );
		assertTrue( "plusEquals real check", x.real == 8 ) ;
	}
	
	@Test
	public void testPlusEqualsImag()
	{
		x.plusEquals( y );
		assertTrue( "plusEquals imag check", x.imag == 16 );
	}
	
	
	@Test
	public void testMag()
	{
		
		assertTrue( "magnitude check ", y.mag() == 13.0 );
		// fail("Not yet implemented");
	}
	
	@Test  (expected = ArithmeticException.class )
	public void testDivideByZero()
	{
		zero.normalize(); // should crash
	}
	
	

}
