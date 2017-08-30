// Slot.java
// CS-212 2016

package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

abstract public class Slot extends JPanel implements ActionListener
{
   //Random randy;
   
   static Yahtzee theYahtzee;  // points to the main class
   
   JButton theButton; // press this to score this item
   String whatFor;  // this slot scores whatFor (label for the button)
   JTextField theScoreField; // field that holds/displays the points
   int score; // the points from the dice for this slot
   static Font f;
   
   boolean used = false; // true means you scored this, can't use again
   
   static Die[] dice; // points to the dice in the DicePanel
   
   static int[] counts = new int[Die.numberOfSides+1]; // temp array,
   // used to compute scores, counts[i] = number of dice with faceUp==i

   // constructor
   public Slot( String wf )
   {
      whatFor = wf;
      //randy = new Random();
      setPreferredSize( new Dimension(300, 30 ) );
       
      if (f==null)  {      f= new Font("TimesNewRoman",0,20); }

      setLayout( new GridLayout(1,2) );
      theButton = new JButton(whatFor);
      theButton.setFont(f);
      add(theButton);
      theButton.addActionListener(this);
      
      theScoreField = new JTextField("",5);
      theScoreField.setFont(f);
      theScoreField.setHorizontalAlignment(JTextField.RIGHT);
      theScoreField.setEditable(false);
      theScoreField.setBackground( Color.white );
      add(theScoreField);
   }

   @Override
   public void actionPerformed( ActionEvent e )
   {
      if ( theYahtzee.theDicePanel.rollCount>0 )
      {
	      // figure out the score and put it in the score field
	      // only do IF you haven't already
	      if ( !used) 
	      {
	         score = computeScore();
	         theScoreField.setText(""+score);
	         used = true;
	         theYahtzee.cleanUp(); // reset dice for next round, check scores
	      }
	      repaint();
      }
   }
   
   // ************************************
   // The rest of the methods are useful for computing scores.
   
   // return the value of the score for this slot
   public int getScore() { return score; }
  
   abstract public int computeScore();
   
   // returns the sum of the dice
   public int sumOfDice()
   {    
	   int total = 0;
	   for ( int i=0; i<5; i++ )
	   {
	      total += dice[i].faceUp;
	   }
	   return total;
   }
   
   // product of non-0 counts
   public int productOfCounts()
   {
	   doCounts();
	   int p = 1;
	   for ( int i=1; i<=Die.numberOfSides; i++ )
	   {
		   int c = counts[i];
	      if ( c>0 ) { p *= c; }
	   }
       return p;
   }
   
   // looks at dice and counts how many of each kind.
   // store in counts[]
   static public void doCounts()
   {
	   for (int i=1; i<=(Die.numberOfSides); i++ ) { counts[i] = 0; }
	   for ( int i=0; i<5; i++ )
	   {
	      counts[dice[i].faceUp]++;
	   }
   }
   
   // return the largest count (in counts[] array)
   public int maxCount()
   {
	   doCounts(); // just to be sure
	   int max = 0;
	   for (int i=1; i<=(Die.numberOfSides); i++ )
	   { 
		   int c = counts[i];
		   if ( c>max ) { max = c; } 
	   }
       return max;
   }
}
