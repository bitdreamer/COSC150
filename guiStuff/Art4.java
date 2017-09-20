// Art4.java
// Barrett Koster 
// COSC-150 hacking from art3 .... make this one do random location boxes

package guiStuff;

import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

public class Art4 extends JFrame
{
   Random randy;

   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art4();
   }
   
   // constructor
   public Art4()
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
   }
   
   // colorGrid draws a 2d array boxes of various colors
   public void colorGrid( Graphics g )
   {
	   for ( int i=0; i<50; i++ )
	   {
		   oneBox(g);
	   }
   }
   
   // draw one random box
   public void oneBox( Graphics g )
   {
	   int x,y;
  
         int red =   randy.nextInt(250); // REDDISH
         int green =  randy.nextInt(250);
         int blue = randy.nextInt( 250);
         g.setColor(  new Color( red, green, blue  )  );
         
         x = randy.nextInt(500);
         y = randy.nextInt(500);
         
         g.fillOval( x, y, 35, 35 );
     
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
