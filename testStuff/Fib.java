package testStuff;

public class Fib
{
   // returns the n-th Fibonacci number
   // does it recursively, so it should bog down at 40 or 50
   public long getNthFib( int n )
   {
	   long f;
	    if ( n==1 || n==2 ) { f = 1; }
	    else 
	    {
	    	   f = getNthFib( n-1 ) + getNthFib( n-2 );
	    }
	    return f;
   }
   
   public static void main( String[] args)
   {
	   Fib f = new Fib();
	   
	   for ( int i=1; i<50; i++ )
	   {
		   double d = f.getNthFib(i);
		   System.out.println("The "+i+"th Fibonacci number is "+d+".");
	   }
   }
   
   
   
}
