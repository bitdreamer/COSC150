package yahtzee;

public class YahtzeeSlot extends Slot
{
   public YahtzeeSlot()
   {
	   super("Yahtzee");
   }
   
   @Override
   public int computeScore()
   {
	   if ( maxCount()==5 ) { score = 50; }
	   else { score = 0; }
	   theScoreField.setText(""+score);
	   return score;
   }
}
