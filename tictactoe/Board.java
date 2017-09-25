package tictactoe;

import java.awt.*;

public class Board
{
   Square[][] theSquares; // 3 x 3 array.
   
   public Board()
   {
      theSquares = new Square[3][3];
      for ( int i=0; i<3; i++ )
      {
         for ( int j=0; j<3; j++ )
         {
            theSquares[i][j] = new Square(i,j);
         }
      }
   }
   
   public void drawMe( Graphics g )
   {
      for ( int i=0; i<3; i++ )
      {
         for ( int j=0; j<3; j++ )
         {
            theSquares[i][j].drawMe(g);
         }
      }

   }
   
}
