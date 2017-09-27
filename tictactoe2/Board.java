package tictactoe2;

// Board.  displays the board, keeps track of who has played
// where, computes winner

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Board extends JPanel
   //implements MouseListener
{
   Square[][] theSquares; // 3 x 3 array.
   static int boardSize = 3; // number of columns or rows
   LinkedList<Scorable> scorables; // each of these represents a way to win
   
   // constructor.  make a grid of square boardSize x boardSize.
   // Also, define all of the Scorables, the ways to win
   public Board()
   {
      // make the grid
      theSquares = new Square[boardSize][boardSize];
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            theSquares[i][j] = new Square(i,j);
         }
      }
     
      // the list for ALL rows and columns and diagonals
      scorables = new LinkedList<Scorable>();
      
      // make a Scorable for each row
      for ( int row=0; row<boardSize; row++ )
      {
         Scorable s = new Scorable();
         for ( int col=0; col<boardSize; col++ )
         {
            s.addSquare( theSquares[row][col] );
         }
         scorables.add(s);
      }
      
      // now make the column Scorables
      for ( int col=0; col<boardSize; col++ )
      {
         Scorable s = new Scorable();
         for ( int row=0; row<boardSize; row++ )
         {
            s.addSquare( theSquares[row][col] );
         }
         scorables.add(s);
      }
      
      // and here are the two diagonal Scorables
      Scorable d1 = new Scorable();
      Scorable d2 = new Scorable();
      for ( int i=0; i<boardSize; i++ )
      { 
         d1.addSquare( theSquares[i][i] );
         d2.addSquare( theSquares[i][boardSize-i-1]);
      }
      scorables.add(d1);
      scorables.add(d2);
      
      setPreferredSize( new Dimension(500,500) );
      //addMouseListener(this);
   }
   
   // this method is how you requested to play on this square.
   // record it as so if this is a legal move.
   public void play( Square theSquare, Player thePlayer )
   {
      if ( !theSquare.isOccupied() ) // only play if still unmarked
      {
         theSquare.setMark( thePlayer.getMark() ); // mark the square
         char w; // index of winner if any, -1 if not
         w = isWinner(); // check for winner
         if ( w != ' ' )
         { reportWinner(w); } // report if there is one
      }   
   }
   
   // returns index of winner if any, ' ' if not
   // how: go through the list of Scorables, see if any are a win
   public char isWinner()
   {
      char win = ' ';
      
      Iterator<Scorable> it = scorables.iterator();
      while ( (win==' ') && it.hasNext() )
      {
         Scorable s = it.next();
         win = s.win();
      }
      
      return win;
   }
   
   // says that this player won
   public void reportWinner( char w )
   {
      JOptionPane.showMessageDialog( null, "player of " + w + " wins.");
   }
   
   
   // draws the Squares of the board and their contents
   //@Override
   //public void paintComponent( Graphics g )
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
   
   // returns the Square where this mouse event is clicked
   public Square squareAt( MouseEvent m )
   {
      Square sq = null;
      
      int i = m.getX() / Square.getSquareSize() - 1;
      int j = m.getY() / Square.getSquareSize() - 1;
      if ( i>=0 && i<boardSize && j>=0 && j<boardSize ) { sq = theSquares[i][j]; }
      
      return sq;
   }
   
   // return the index (0 or 1) of the player[] whose turn it is
   public int whoseTurn()
   {
      // count occupied squares
      int count = 0;
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            if ( theSquares[i][j].isOccupied() ) { count++; }
         }
      }
      
      return ((count)%2);
   }
   
   static int getBoardSize() { return boardSize; } 
}
