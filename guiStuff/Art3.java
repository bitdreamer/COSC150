// Art3.java
// Barrett Koster for CS-212 class 2013

package guiStuff;

import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

public class Art3 extends JFrame
{
   Random randy;

   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art3();
   }
   
   // constructor
   public Art3()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      randy = new Random();
      
      System.out.println("wefwef");
      
      setSize( 500,500);
      setVisible( true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);

      // notebook(g);
      colorGrid(g);
      
      //oneRow(g, 300 );
      
   }
   
   // colorGrid draws a 2d array boxes of various colors
   public void colorGrid( Graphics g )
   {
      int y;
      for ( y=100; y<460; y = y + 40 )
      {
         oneRow( g, y );
      }
   }
   
   // oneRow draws a horizontal row of boxes 35x35 starting at 
   // x=100 and top of boxes is y (argument).  spacing is 5,
   // so 40 total from left corner to left corner
   public void oneRow( Graphics g, int y )
   {
      for ( int x=100; x<460; x = x+ 40 )
      {
         
         int red =   100+ randy.nextInt(156); // REDDISH
         int green = 100 + randy.nextInt(156);
         int blue = randy.nextInt( 156);
         g.setColor(  new Color( red, green, blue  )  );
         
         g.setColor(  new Color( x/2, 255- y/2, 0 )  ); // color gradient
         
         g.fillRect( x, y, 35, 35 );
      }
   }
   
   public void notebook(Graphics  g)
   {
      g.setColor( new Color(150,150,250) );
      for ( int y=100; y<500; y=y+30 )
      {
         g.drawLine( 20, y, 480, y );
      }
   }
}
