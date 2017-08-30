package yahtzee;

public class NofAKindSlot extends Slot
{
   int n;  // how many dice we need of same kind to count it
   
   public NofAKindSlot( int d )
   {
      super(""+d+"s of a kind");
      n = d;
   }

   @Override
   public int computeScore()
   {
	  score = 0;
	  if ( maxCount() >= n ) { score = sumOfDice(); }
      //theScoreField.setText(""+score);
      return score;
   }
}
