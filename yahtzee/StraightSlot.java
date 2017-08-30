package yahtzee;

public class StraightSlot extends Slot
{
	int need; // how long this straight must be to count, 
	int value;  // how many points you get if you make it
	
	   public StraightSlot( String s, int need, int value )
	   {
	      super(s);
	      this.need = need;
	      this.value = value;
	   }

      @Override
	  public int computeScore()
	  {
	     score = 0;
		 if ( longest() >= need ) { score = value; }
		   
         //theScoreField.setText(""+score);
		 return score;
	   }
	   
	   // returns the length of the longest straight
	   public int longest()
	   {
		  int st = 0; // length of current straight (as i increases)
		  int maxst = 0; // longest seen so far
		  doCounts();
		  for ( int i=1; i<=Die.numberOfSides; i++ )
		  {
			  if (counts[i]>0 ) { st++; if ( st>maxst) { maxst = st; } }
			  else { st = 0; }
		  }

		  System.out.println("longest="+maxst);
	      return maxst;
	   }
}
