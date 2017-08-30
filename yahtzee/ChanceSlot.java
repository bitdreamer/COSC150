package yahtzee;

public class ChanceSlot extends Slot
{
   public ChanceSlot()
   {
	   super("chance");
   }
   
   @Override
   public int computeScore()
   {
	   score = sumOfDice();
	   theScoreField.setText(""+score);
	   return score;
   }
}
