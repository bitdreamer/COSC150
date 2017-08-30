package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotBonus extends TotalSlot
{
   public SlotBonus()
   {
      super("bonus");
   }
   
   // add up slots 0 - 5 and put 35 here IFF sum is >= 63
   @Override
   public int computeScore()
   {
      super.computeScore();
	  if ( score>= 63 ) { score = 35; }
	  else { score = 0; }
      //theScoreField.setText(""+score);
      
      return score;
   }
}
