package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Board
{
   Square[][] theSquares; // boardSize x boardSize array.
   static int boardSize = 3;
   LinkedList<Scorable> possibleWins;
   
   public Board()
   {
      possibleWins = new LinkedList<Scorable>();
      
      theSquares = new Square[boardSize][boardSize];
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            theSquares[i][j] = new Square(i,j);
         }
      }
      
      // add squares in various ways to the Scorables in the 
      // possibleWins list
      // go through the columns
      for ( int i=0; i<boardSize; i++ )
      {
         Scorable s = new Scorable(); // one col
         for ( int j=0; j<boardSize; j++ )
         {
            s.addSquare(theSquares[i][j]);
         }
         possibleWins.add(s);
      }
      // do the rows
      for ( int j=0; j<boardSize; j++ )
      {
         Scorable s = new Scorable(); // one row
         for ( int i=0; i<boardSize; i++ )
         {
            s.addSquare(theSquares[i][j]);
         }
         possibleWins.add(s);
      }
      
     // diagonals
      Scorable d1 = new Scorable();
      Scorable d2 = new Scorable();
      for ( int i=0; i<boardSize; i++ )
      {
         d1.addSquare( theSquares[i][i]);
         d2.addSquare( theSquares[i][boardSize-i-1]);
      }
      possibleWins.add(d1);
      possibleWins.add(d2);

      
      
   }
   
   // take the mouse event and return the square that got
   // clicked on.  return null if they didn't click on anything.
   public Square findSquare( MouseEvent m )
   {
      Square sq = null;
      
      int i = m.getX() / Square.getSquareSize() - 1;
      int j = m.getY() / Square.getSquareSize() - 1;
      
      if( i>=0 && i<boardSize && j>=0 && j<boardSize )
      {
         sq = theSquares[i][j];
      }
      
      return sq;
   }
   
   
   // return index of player whose turn it is.  
   // how: count filled square, then to mod 2
   public int whoseTurn()
   {
      int whose;
      
      int count = 0;
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            if ( theSquares[i][j].getMark() != ' ' ) {count++;}
         }
      }
      whose = count%2;

      return whose;
   }
   
   public void drawMe( Graphics g )
   {
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            theSquares[i][j].drawMe(g);
         }
      }
   }
   
   // return the mark of the winner if there is one
   public char winner()
   {
      char win = ' ';
      
      Iterator<Scorable> it = possibleWins.iterator();
      while ( win==' ' && it.hasNext() )
      {
         Scorable s = it.next();
         win = s.win();
         if ( win !=' ' )
         { JOptionPane.showMessageDialog(null,""+win+" wins!"); }
      }

      return win;
   }
   
   public static int getBoardSize() { return boardSize; }  
}
