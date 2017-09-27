package tictactoe2;

import java.awt.*;

public class Square
{
   int x, y; // coords of upper left of this Square
   int i,j;  // index in the array in Board
   static int squareSize;
   char mark = ' ';  // this could also be done by owner, but ... 
   
   // constructor. takes the index i,j of this square from upper left
   public Square( int i1, int j1)
   {
      squareSize = 300/Board.getBoardSize();
      i = i1;
      j = j1;
      
      x = squareSize + squareSize * i;
      y = squareSize + squareSize * j;
   }
   
   // draws this square and the contents (x or o)
   public void drawMe( Graphics g )
   {
      g.drawRect( x, y, squareSize, squareSize );
      int nuj = squareSize/2-5;
      g.drawString(""+mark, x+nuj, y+nuj );
   }
   
   // access
   public static void setSquareSize( int s ) { squareSize = s; }
   public static int getSquareSize() { return squareSize; }
   public boolean isOccupied() { return (mark=='x' || mark=='o'); }
   public char getMark() { return mark; }
   public void setMark( char m ) { mark = m; }
}
