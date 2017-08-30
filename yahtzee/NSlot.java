package yahtzee;

public class NSlot extends Slot
{
   int dots;  // the number we are looking for on the dice
   
   public NSlot( int d )
   {
      super(""+d+"s");
      dots = d;
   }

   @Override
   public int computeScore()
   {
      score = 0;
      for ( int i=0; i<5; i++ )
      {
         if ( dice[i].faceUp==dots )  { score += dots; }
      }
      //theScoreField.setText(""+score);
      return score;
   }
}
