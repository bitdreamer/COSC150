/*
   Partish.java
   This class takes an array of ints and counts how many of
   each value there are.  This information is stored a couple
   of ways.  
   1. Partish theParts, which has an ordered list of PartishParts
   each of which holds a number from the original array and a count
   of how many time it occurs.  Partish is ordered so that the ones
   with the highest counts are first.
   2. a flat array of counts for all possible numbers

 
 */

package stingy;
 
import java.util.*;

public class Partish
{
   protected int[] orig; // the array that is input
   protected int len; // length of this input array
   protected boolean[] used; // true iff already counted
   protected Vector<PartishPart> theParts; // 
   protected int[] flatCount; // flatCount[k] tells how many times k occured 
                              // in the original sequence
   
   public Partish( int[] lucky )
   {
	   System.out.println("Partish: entering ...");
	   theParts = new Vector<PartishPart>();
	   
	   // make a copy of incoming data
	   len = lucky.length;
	   orig = new int[len];
	   for ( int i=0; i<len; i++ )
	   {
		   orig[i] = lucky[i];
	   }
	   
	   flatInit(); // initialize the flatCount array
	   
	   // go through data, for each unused number in lucky, make 
	   // PartishPart and count all other occurrences.
	   
	   // setup used array
	   used = new boolean[len];
	   for ( int i=0; i<len; i++ ) { used[i] = false; }
	   
	   // find each unused value in input and make PartishPart for it
	   int origi = 0; // which input number are we considering	   
	   while ( origi < len )
	   {
		   // advance to next unused input if any, start by considering
		   // current origi
		   while ( origi < len && used[origi] ) { origi++; }
		   
		   if ( origi < len )
		   {
			   // orig[origi] is a not-yet-seen number, 
			   PartishPart pp = new PartishPart( orig[origi] );
			   theParts.add( pp );
			   
			   // add to PartishPart.count all repeat occurrences of current number
			   for ( int j=origi+1; j<len; j++ )
			   {
				   if ( orig[j] == orig[origi] )
				   {
					   pp.addOne();
					   used[j] = true;
				   }
			   }
			   used[origi] = true; // and now we have used orig[origi];
		   }
	   }
	   
	   // order the Vector biggest to smallest
	   theParts.sort( new PPComparator() );
	   
	   report();
   }
   
   public void flatInit()
   {
	   int max = StingySlot.maxToken;
	   flatCount = new int[max+1]; // use 1 to max (not 0 to max-1 )
	   for ( int j=1; j<=max; j++ ) { flatCount[j] = 0;}
	   
	   //System.out.println("Partish.flatInit: len="+len+" ");
	   for ( int i=0; i<len; i++ ) { flatCount[orig[i]]++; }
   }
   
   public void report()
   {
	   System.out.println("Partish.report: entering .... ");
	   Iterator<PartishPart> it = theParts.iterator();
	   while ( it.hasNext() )
	   {
		   PartishPart pp = it.next();
		   System.out.println("PartishPart: "+pp.getId()+" "+pp.getCount());
	   }
   }
   
   public static void main( String[] args )
   {
	   int[] t1 = { 33,45,2,1,7,45,6,2,7,1,7,45,45,45};
	   Partish p = new Partish( t1 );
   }
   
   // return the count from the (which)th partition
   // if we are past the array, return 0, do not crash
   public int getPartSize( int which )
   {
	   int ret=0;
	   
	   if (which < theParts.size())
	   {
		   PartishPart pp = theParts.get(which);
		   ret = pp.count;
	   }
	   
	   return ret;
   }
   
   // returns the count for the number which in the random set.
   public int getCount( int which )
   {
	   return flatCount[which];
   }
   
   
   
}
