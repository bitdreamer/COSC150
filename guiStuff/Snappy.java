// Snappy.java
// 

package guiStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snappy extends JFrame 
   implements MouseListener, MouseMotionListener
{
   // attributes
   int downX, downY; // where the mouse is when button is pressed
   int mouseX, mouseY; // mouse last seen at
   int upX, upY; // where mouse is when button is released

   public static void main ( String [] args )
   {
      new Snappy();
   }
   
   // constructor
   public Snappy()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("SnapLines");
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      setSize(500,500);
      setVisible(true);
   }
   
   // MouseListener methods (5 of them)
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   
   // record position of mouse when mouse button is pressed
   @Override public void mousePressed ( MouseEvent m )
   {
      mouseX = downX = m.getX(); 
      mouseY = downY = m.getY();
      repaint();
   }
   @Override public void mouseReleased( MouseEvent m )
   {
      mouseX = upX = m.getX();
      mouseY = upY = m.getY();
      repaint();
   }
   @Override public void mouseClicked ( MouseEvent m ) {}
   
   // MouseMotionListener methods (just 2 needed)
   // when the mouse is dragged, update the mouseXY position
   @Override public void mouseDragged ( MouseEvent m )
   {
      mouseX = m.getX();
      mouseY = m.getY();
      repaint();
   }
   
   @Override public void mouseMoved   ( MouseEvent m ) {}
   
   @Override
   public void paint( Graphics g )
   {  
      super.paint(g);
      //g.drawLine( downX, downY, upX, upY );
      g.drawLine( downX, downY, mouseX, mouseY );     
      // g.drawRect( downX, downY, mouseX-downX, mouseY-downY );
   }
}
