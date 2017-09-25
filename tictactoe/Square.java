package tictactoe;

import java.awt.*;

public class Square
{
   int x, y; // coords of upper left of this Square
   int i,j;  // index in the array in Board
   int squareSize = 100;
   
   public Square( int i1, int j1)
   {
      i = i1;
      j = j1;
      
      x = squareSize + squareSize * i;
      y = squareSize + squareSize * j;
   }
   
   public void drawMe( Graphics g )
   {
      g.drawRect( x, y, squareSize, squareSize );
   }
}
