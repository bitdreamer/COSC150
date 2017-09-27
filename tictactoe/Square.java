package tictactoe;

import java.awt.*;

public class Square
{
   int x, y; // coords of upper left of this Square
   int i,j;  // index in the array in Board
   static int squareSize = 100;
   char mark; // 'x' or 'o' or ' ' (space) for starters
   
   public Square( int i1, int j1)
   {
      i = i1;
      j = j1;
      
      x = squareSize + squareSize * i;
      y = squareSize + squareSize * j;
      
      mark = ' ';
   }
   
   public void drawMe( Graphics g )
   {
      g.drawRect( x, y, squareSize, squareSize );
      
      g.drawString( ""+mark, x+20, y+20 );
   }
   
   public static int getSquareSize() { return squareSize; } 
   public void setMark( char m ) { mark = m; }   
   public char getMark() { return mark; }
}
