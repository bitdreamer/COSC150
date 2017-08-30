package testStuff;

import static org.junit.Assert.*;

import org.junit.*;

public class testFib
{
   Fib f;
   
   @Before 
   public void before()
   {
	   f = new Fib();
   }
	
   @Test
   public void test4()
   {
	   long a4 = f.getNthFib( 4 );
	   assertTrue( "4th fib number is 3?", a4==3 );
   }
   
   @Test
   public void test8()
   {
	   long a8 = f.getNthFib( 8 );
	   assertTrue( "8th fib number is 21?", a8==21 );
   }
   
   @Test(timeout=200)
   public void testn()
   {
	    
	   int n = 16; long c = 987; // n and fib(n) correct
	   n = 35; c = 9227465;
	   n = 39; c = 63245986;
	   //n = 40; c = 102334155;
	   long a = f.getNthFib( n );
	   assertTrue( ""+n+"th fib number is ...", a==c );
	   
   }
	

}
