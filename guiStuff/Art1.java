// Art1.java
// Barrett Koster for CS-212 class 2013

package guiStuff;

import java.awt.*;
import javax.swing.*;

public class Art1 extends JFrame
{
   public static void main( String[] args )
   {
      new Art1(); // declares one of these objects
   }
   
   // constructor
   public Art1()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setSize( 800,500);
      setVisible( true);
   }
   
   // get called automatically any time the window needs to be redrawn
   @Override
   public void paint( Graphics g )
   {
      super.paint(g); // call to JFrame paint()
      
      g.drawLine( 50, 50, 250, 100 );  // xy xy from upper left
      g.drawRect( 50, 150, 100, 30 );   // x y w h
      g.drawOval( 50, 150, 100, 300 );
      g.setColor( Color.pink );
      g.fillRect(200,200,50,50 );
      g.drawString("blah blah",300,300);
      
      int[] x = new int[3];
      int[] y = new int[3];
      x[0] = 500; x[1] = 400; x[2] = 350;
      y[0] = 350; y[1] = 150; y[2] = 400;
      
      g.setColor( Color.red );
      g.fillPolygon( x, y, 3 );
     
   }
}
