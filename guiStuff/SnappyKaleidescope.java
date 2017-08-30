package guiStuff;
// SnappyKaleidescope.java
// 



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SnappyKaleidescope extends JFrame 
   implements MouseListener, MouseMotionListener
{
   // attributes
   int downX, downY; // where the mouse is when button is pressed
   int mouseX, mouseY; // mouse last seen at
   int upX, upY; // where mouse is when button is released

   public static void main ( String [] args )
   {
      new SnappyKaleidescope();
   }
   
   // constructor
   public SnappyKaleidescope()
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
      //super.paint(g);
      //g.drawLine( downX, downY, upX, upY );
	      g.drawLine( downX, downY, mouseX, mouseY );   
	      g.drawLine( downX, 500-downY, mouseX, 500-mouseY );   
	      g.drawLine( 500-downX, downY, 500-mouseX, mouseY );   
	      g.drawLine( 500-downX, 500-downY, 500-mouseX, 500-mouseY );   
    
      // g.drawRect( downX, downY, mouseX-downX, mouseY-downY );
   }
}
