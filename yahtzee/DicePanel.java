package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DicePanel extends JPanel implements ActionListener
{
   Die[] dice; // 5 dice, you roll these, count them ...
   int diceCount = 5;  // how many dice (5)
   JButton rollButton; // click this to roll the dice.
   int rollCount=0; // counts up to 3 rolls per turn

   public DicePanel()
   {
	  setLayout( new FlowLayout() );
	   
      dice = new Die[diceCount];
      for ( int i=0; i<diceCount; i++ )
      {
         dice[i] = new Die();
         add( dice[i]);
      }
      
      rollButton = new JButton("roll");
      add( rollButton );
      rollButton.addActionListener( this );
      rollButton.setFont(Die.f);
   }
  
   // only possible event is hitting the roll button
   public void actionPerformed( ActionEvent e )
   {
	   rollAll();
	   repaint();
   }
   
   // tell all of the dice to roll themselves
   // IF we have not already rolled 3 times.  
   public void rollAll()
   {
      if ( rollCount < 3 )
      {
	      for ( int i=0; i<diceCount; i++ )
	      {
	         dice[i].roll();
	      }
	      rollCount++;
      }
      Slot.doCounts();
   }

   public void reset()
   {
      for ( int i=0; i<5; i++ ) { dice[i].reset(); }
      rollCount = 0; 
      repaint();
   }

}
