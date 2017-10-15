// Elf.java
// 2014 CS-212 Barrett Koster

package mousing;

import java.awt.*;

public class Elf
{
   protected int x; // screen coordinates in pixels of top of hat
   protected int y;
   
   protected Color color;
   
   protected boolean surprised; // 
   
   // Elf constructor
   public Elf( int x1, int y1, boolean surprised1 )
   {
      x = x1;
      y = y1;
      surprised = surprised1;
      color = new Color(
            (int)(Math.random()*250), 
            (int)(Math.random()*250), 
            (int)(Math.random()*250)
            );
   }
   
   // draws and elf, looks like a little house 
   public void drawMe( Graphics g )
   {
      g.setColor( color );
      g.drawLine( x, y, x-20, y+30 );
      g.drawLine( x, y, x+20, y+30 );
      g.drawRect( x-20, y+30, 40, 40 );
      
      if ( surprised ) { g.drawOval( x, y+55, 10, 10 ); }
      else { g.drawLine(x-10, y+60, x+10, y+60 ); }
   }
}
