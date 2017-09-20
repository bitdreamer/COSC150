package guiStuff;

import java.awt.*;
import javax.swing.*;

public class Mondrian extends JFrame
{
   public static void main(String[] args )
   {
      new Mondrian();
   }
   
   public Mondrian()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("Mondrian");
      
      setSize( 800,500);
      setVisible( true);

   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      box(g,5 ,0, 500, 0, 500); // g, levels, x range, y range
   }
   
   public void box( Graphics g, int level, int x1, int x2, int y1, int y2 )
   {
      
      g.drawRect( x1, y1, x2-x1, y2-y1 );
      if ( level>0)
      {
         if ( level%2==0 )
         {
            int cut = (int) ( x1 + (x2-x1) * Math.random());
            
            box( g, level-1, x1, cut, y1, y2 );
            box( g, level-1, cut, x2, y1, y2 );
         }
         else
         {
            int cut = (int) ( y1 + (y2-y1) * Math.random());
            
            box( g, level-1, x1, x2, y1, cut );
            box( g, level-1, x1, x2, cut, y2 );
            
         }
      }
   }
}
