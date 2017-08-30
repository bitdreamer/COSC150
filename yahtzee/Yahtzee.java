// yahtzee.java
// CS-212 2016
// Starting to play the game Yahtzee, one player version.

package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Yahtzee extends JFrame
   //implements ActionListener
{
   //JPanel dicePanel; // top of the window, holds dice and roll button
   DicePanel theDicePanel;
   JPanel upperPanel; // holds 'upper' scores for Yahtzee, do west
   JPanel lowerPanel; // holds 'lower' scores, put in the east
   JPanel totalPanel; // holds grand total and reset button, put south
   
   Slot[] slots; // places to put all of the scores.

   public static void main ( String [] args )
   {
      new Yahtzee();
   }
   
   // constructor
   public Yahtzee()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Yahtzee");
      
      Slot.theYahtzee = this;
      
      setLayout( new BorderLayout() );
      
      // do the dice panel
      theDicePanel = new DicePanel();
      add( theDicePanel, BorderLayout.NORTH );
      Slot.dice = theDicePanel.dice; // so the Slots can look at the dice
      
      upperPanel = new JPanel();
      add( upperPanel, BorderLayout.WEST );
      upperPanel.setLayout( new GridLayout(8,1) );
      //
      slots = new Slot[17];
      TotalSlot ts; // temp variable, used when making TotalSlots
      slots[0] = new NSlot(1); // Slot("1s"); 
      slots[1] = new NSlot(2); 
      slots[2] = new NSlot(3); 
      slots[3] = new NSlot(4); 
      slots[4] = new NSlot(5); 
      slots[5] = new NSlot(6); 
      slots[6] = ts = new SlotBonus(); 
         for (int i=0; i<6; i++ ) { ts.addToSumList( slots[i] ); }
      slots[7] = ts = new TotalSlot("upper total");
         for (int i=0; i<7; i++ ) { ts.addToSumList( slots[i] ); }
      //
      for ( int i=0; i<8; i++ ) { upperPanel.add( slots[i] ); }
      
      lowerPanel = new JPanel(); 
      add( lowerPanel, BorderLayout.EAST );
      lowerPanel.setLayout( new GridLayout(8,1) );
      
      slots[ 8] = new NofAKindSlot(3); // new Slot("3 of a kind");
      slots[ 9] = new NofAKindSlot(4); //new Slot("4 of a kind");
      slots[10] = new HouseSlot();
      slots[11] = new StraightSlot("small straight", 4, 30 );
      slots[12] = new StraightSlot("large straight", 5, 40 );
      slots[13] = new YahtzeeSlot();
      slots[14] = new ChanceSlot();
      slots[15] = ts = new TotalSlot("lower total");
         for (int i=8; i<=14; i++ ) { ts.addToSumList( slots[i] ); }
     
      for ( int i=8; i<16; i++ ) { lowerPanel.add( slots[i] ); }
      
      totalPanel = new JPanel();// totalPanel.setBackground(Color.GREEN);
      add(totalPanel,BorderLayout.SOUTH);
      slots[16] = ts = new TotalSlot("grande total");
         ts.addToSumList(slots[15]); ts.addToSumList(slots[7]);
      totalPanel.add(slots[16]);
            
      setSize(700,500);
      setVisible(true);
   }
 
   // reset the dice for next turn, update scores ,
   // set rollCount back to 0.
   public void cleanUp()
   {
	  theDicePanel.reset();
      slots[6].computeScore();
      slots[7].computeScore();
      slots[15].computeScore();
      slots[16].computeScore();
      repaint();
   }

}
