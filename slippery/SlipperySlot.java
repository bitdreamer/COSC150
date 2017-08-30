// SlipperySlot.java
// Koster and Sherr for 2016 COSC-150
// This version has bugs in it.

package slippery;

import java.util.*;

import stingy.Partish;

public class SlipperySlot {
	
	protected Random randy; // will be used to generate random numbers
	protected int luckyLength=5; // number of numbers that you get when you play 
	protected int[] lucky; // array of random numbers that may win
	protected static final int maxToken=50; // the biggest that the random number can get.
	protected int winnings; // the payoff value, when computed
	
	public static void main( String[] args )
	{
		SlipperySlot ss = new SlipperySlot();
		ss.pullTheLever();
		ss.payOff();
		ss.report();


	}
	
	// constructor
    public SlipperySlot()
    {
	    randy = new Random();
	    lucky = new int[luckyLength];	   	   	   
    }
    
    /**
     * Converts an array of ints into a string
     *
     * @return the string version of the array
     * @param an array of ints
     */
    public static String drawingToString( int[] m ) {
        assert( m.length == 5 );
        String res = "[ ";
        for ( int n : m ) {
                res += n + " ";
        }
        res += "]";
        return res;
    }
    
    /**
     * converts the lucky array to a string, suitable for output
     */
    public String drwaingToString() {
    	String res = "[";
    	for ( int i=0; i<luckyLength; i++ )
    	{ res += lucky[i] + " "; }
    	res += "]";
    	return res;
    }
   
    /**
     * return an array of ints that might win something, a "drawing"
    */
    public int[] pullTheLever()
    {	   
	    for ( int i=0; i<luckyLength; i++ )
	    {
		   lucky[i] = randy.nextInt(maxToken) +1;
	    }
	    return lucky;
    }
    /**
     for testing, here's a version of the payoff method that lets the calling program
     put in the array of numbers.
     @param array of ints to be check for money, note length must match 
         luckyLength, as of this writing =5.
     */
    public int payOff( int[] rig )
    {
    	luckyLength = rig.length;
	    for ( int i=0; i<rig.length; i++ )
	    {
		   lucky[i] =  rig[i];
	    }
    	
	    return payOff();
    }
    
    // return the value won by the numbers in lucky
    public int payOff()
    {
    	winnings=0; // This is what you win.  Starts at 0.
    	
        Partish p = new Partish(lucky);
        
        if ( p.getPartSize(0) == 5 ) { winnings += 1000000; }
        
        if ( p.getPartSize(0) == 4 ) { winnings += 1000; } // should be 10000
        
        if ( p.getPartSize(0) == 3 && p.getPartSize(1) == 2 ) { winnings += 5000; }
        
        // if ( p.getPartSize(0) == 3 && p.getPartSize(1) == 1 ) { winnings += 100; } should be in
        
        if ( p.getPartSize(0) == 2 && p.getPartSize(1) == 1 ) { winnings += 10; }
        
        if (    p.getCount( 1)>0 
             || p.getCount( 4)>0
             || p.getCount( 9)>0
           //  || p.getCount(16)>0  should be in
             || p.getCount(25)>0
             || p.getCount(36)>0
             || p.getCount(49)>0
           )
        { winnings += 7; }
        
        if ( p.getCount(42)>0 ) { winnings += 2; }
        
        if (    p.getCount( 1)>0 
             || p.getCount( 2)>0
             || p.getCount( 4)>0
             || p.getCount( 8)>0
             || p.getCount(16)>0
             || p.getCount(32)>0
           )
           { winnings += 3; }
     
    	
    	return winnings;
    }
    
    public void report()
    {
    	System.out.print("random numbers :");
	    for ( int i=0; i<luckyLength; i++ )
	    {
		   System.out.print(" "+lucky[i]);
	    }
	    System.out.println(" pays $"+winnings+".");

    }
    
    /**
     * for debugging purposes, this sets the value of lucky, the array of ints
     * containing the drawing
     */
    public void setLucky( int[] m )
    {
    	lucky = new int[m.length ];
    	for ( int i=0; i<m.length; i++ )
    	{
    		lucky[i] = m[i];
    	}
    }

}
