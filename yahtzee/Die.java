// Die.java
// CS-212 2016
// singular of "dice", the noun, not the verb.

package yahtzee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Die extends JPanel
   implements MouseListener
{
   static final int numberOfSides=6; // numbering is one to this number
   int faceUp; // the number currently rolled, we allow 0 to mean 
               // not rolled/usable yet
   static Font f;
   static Random randy;
   boolean hold; // false means it rolls, true means is stays at faceUp
   
   
   // constructor
   public Die()
   {
      hold = false; // start letting it roll
      
      if (f==null) {      f= new Font("TimesNewRoman",0,30); }
      
      setPreferredSize( new Dimension(50,50) );
      
      if ( randy==null )      { randy = new Random(); }

      reset();
   
      addMouseListener(this);
   }
   
   // randomly set faceUp and return that number
   public int roll()
   {
      if ( !hold) { faceUp = (int)(1+numberOfSides*Math.random()); }
      return faceUp; // stub 
   }
   
   public int getFaceUp() { return faceUp; }
   public void reset() { hold = false; faceUp = 0; setBackground(Color.WHITE);}

   @Override public void mouseClicked ( MouseEvent m )
   {
      hold = !hold;
      
      if ( hold ) { setBackground(Color.pink); } 
      else        { setBackground(Color.white); }
   }
   @Override public void mousePressed ( MouseEvent m ) {}
   @Override public void mouseReleased( MouseEvent m ) {}
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      g.setColor( Color.black );
      if (numberOfSides==6)
      {
	      if ( faceUp==1 || faceUp==3 || faceUp==5){ g.fillOval(22,22,7,7); }
	      if ( faceUp>=2 ) { g.fillOval( 5,5 ,7,7 ); g.fillOval( 40,40,7,7);  }
	      if ( faceUp>=4 ) { g.fillOval( 5,40,7,7 ); g.fillOval( 40,5,7,7); }
	      if ( faceUp==6 ) { g.fillOval( 5, 22,7,7); g.fillOval( 40, 22,7,7); }
      }
      else { g.setFont(f); g.drawString(""+faceUp, 10, 40 ); }
   }
}
