// StingySlot.java
// working from SlipperySlot by Koster and Sherr 2016 COSC-150
// This version has bugs in it.

package stingy;

import java.util.*;

public class StingySlot
{	
	protected Random randy; // will be used to generate random numbers
	protected int spinLength=5; // number of numbers that you get when you play 
	protected int[] spin; // array of random numbers that may win
	protected static final int maxToken=60; // the biggest that the random number can get.
	protected double winnings; // the payoff value, when computed
	
	public static void main( String[] args )
	{
		StingySlot ss = new StingySlot();
		
		ss.doSpin();
		ss.payoff();
		ss.report();
	}
	
	// constructor
    public StingySlot()
    {
	    randy = new Random();
	    spin = new int[spinLength];	   	   	   
    }
    
    /**
     * Converts an array of ints into a string [ # # # # ... # ]
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
     * converts the spin array to a string, suitable for output
     */
    public String drawingToString() {
    	String res = "[";
    	for ( int i=0; i<spinLength; i++ )
    	{ res += spin[i] + " "; }
    	res += "]";
    	return res;
    }
   
    /**
     * return an array of ints that might win something, a "spin" of the numbers
    */
   public int[] doSpin()
    {	   
	    for ( int i=0; i<spinLength; i++ )
	    {
		   spin[i] = randy.nextInt(maxToken) +1;
	    }
	    return spin;
    }
   
   
    /**
     */
   public int[] getSpin()
   {
	   return spin;
   }
    /* *
     for testing, here's a version of the payoff method that lets the calling program
     put in the array of numbers.
     @param array of ints to be check for money, note length must match 
         luckyLength, as of this writing =5.
     */
   /*
    public double payOff( int[] rig )
    {
    	spinLength = rig.length;
	    for ( int i=0; i<rig.length; i++ )
	    {
		   spin[i] =  rig[i];
	    }
    	
	    return payOff();
    }*/
    
    /**
     * make it at though the argument rig was the random spin
     * Note: rig length needs to be at least spinLength
     *
     * @param rig the array of numbers to set the spin to.  
     * 
     */
    public int[] setSpin( int[] rig )
    {
	    for ( int i=0; i<spinLength; i++ )
	    {
		   spin[i] =  rig[i];
	    }
	    return spin;
    }
    
    // compute and return the payoff value for the current spin
    public double payoff()
    {    	
    	winnings=0; // This is what you win.  Starts at 0.
    	
        Partish p = new Partish(spin);
        
        if ( p.getPartSize(0) == 5 ) { winnings += 1000000; }
        
        if ( p.getPartSize(0) == 4 ) { winnings += 500; }
        
        if ( p.getPartSize(0) == 3 && p.getPartSize(1) == 2 ) { winnings += 50; }
        
        if ( p.getPartSize(0) == 3 && p.getPartSize(1) == 1 ) { winnings += 10; }
        
        //if ( p.getPartSize(0) == 2 && p.getPartSize(1) == 2 ) { winnings += 4; } 
        
        if ( p.getPartSize(0) == 2 && p.getPartSize(1) == 1 ) { winnings += 2; }
        
        // reward perfect squares
        double perfectReward = 0.1;     
        double pf = (  p.getCount( 1)
        		     + p.getCount( 4)
 		             + p.getCount( 9)
 		             + p.getCount(16)
 		             //+ p.getCount(25)
 		             + p.getCount(36)
 		             + p.getCount(49)
 		            ) * perfectReward;
        winnings += pf;
       
        // reward occurrences of 42
        double reward42 = 0.35;
        winnings += p.getCount(42) * reward42;
        
        // reward multiples of 17
        double reward17 = 0.17;
        winnings += ( p.getCount(17) + p.getCount(34) /*+ p.getCount(51)*/ ) * reward17; 
    	
    	return winnings;
    }
    
    // shows your spin and the payoff for it
    public void report()
    {
    	System.out.print("random numbers :");
	    for ( int i=0; i<spinLength; i++ )
	    {
		   System.out.print(" "+spin[i]);
	    }
	    System.out.println(" pays $"+winnings+".");

    }
    
    /**
     * for debugging purposes, this sets the value of lucky, the array of ints
     * containing the drawing
     */
    public void setLucky( int[] m )
    {
    	spin = new int[m.length ];
    	for ( int i=0; i<m.length; i++ )
    	{
    		spin[i] = m[i];
    	}
    }

}
