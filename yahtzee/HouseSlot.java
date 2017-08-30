package yahtzee;

public class HouseSlot extends Slot
{
   public HouseSlot()
   {
      super("full house");
   }

   @Override
   public int computeScore()
   {
      int p = productOfCounts();
	  if ( p == 6 ) { score = 25; }
	  else {	  score = 0; }

      //theScoreField.setText(""+score);

      return score;
   }
}
