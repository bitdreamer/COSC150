// northPole.java
// Barrett Koster CS-212 class spring 2013
// This class shows how to make an app listen for mouse clicks in the window.

package mousing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class northPole extends JFrame implements MouseListener, ActionListener
    , MouseMotionListener
{
   protected Elf sam; //
   
   protected Elf[] workForce; // place to hold all of the Elf objects
   protected int elfCount = 0; // how many so far in the array
   
   JButton surpriseButton;
   protected boolean surprise = false;
   
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new northPole();
   }
   
   // constructor, add the MouseListener
   public northPole()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      workForce = new Elf[10];
      
      setLayout( new FlowLayout() );
      surpriseButton = new JButton("surprise");
      add(surpriseButton);
      surpriseButton.addActionListener( this );
      
      
      workForce[elfCount++] = new Elf( 100, 200, true );
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   // when the mouse is clicked, print out the coordinates.
   public void mouseClicked( MouseEvent e )
   {
      int x = e.getX(); int y = e.getY();
      
      System.out.println("click at x="+e.getX()+" y="+e.getY());
      
      //sam = new Elf( x, y, surprise );
      
     // workForce[ elfCount ] = sam;
     // elfCount++;
      
      workForce[elfCount++] = new Elf( x, y, surprise );
      
      repaint();
   }
   public void mouseEntered( MouseEvent e ) {}
   
   // this is the start of a drag
   public void mousePressed( MouseEvent e )
   {
      sam = findElf( e.getX(), e.getY() );
   }
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   
   public void mouseMoved( MouseEvent e ) {}
   public void mouseDragged( MouseEvent e )
   {
      if ( sam != null )
      {
          sam.x = e.getX();
          sam.y = e.getY();
      }
      repaint();
   }
   
   
   // findElf takes xy coordinates and returns the Elf close to that
   // returns null if not found.
   public Elf findElf( int clickx, int clicky )
   {
      for ( int i=0; i<elfCount; i++ )
      {
         double xdif = clickx - workForce[i].x;
         double ydif = clicky - workForce[i].y; 
         double dist = Math.sqrt( xdif*xdif + ydif*ydif );
         if ( dist < 50  ) { return workForce[i]; }
      }
      return null;
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==surpriseButton ) { surprise = !surprise; }
      repaint();
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      // if ( sam!=null) { sam.drawMe( g ); }
      
      for ( int i=0; i<elfCount; i++ )
      {
         workForce[i].drawMe(g);
      }
   }
   
}
