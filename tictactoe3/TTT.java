// TTT.java
// COSC-150 fall 2017
// tictactoe3 ... get the computer player working ....

package tictactoe3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class TTT extends JFrame
   implements MouseListener
{
   Player[] player; // two players, X is player[0], O is player[1]
   Board theBoard;
   
   public static void main ( String[] args )
   {
      new TTT();
   }
   
   // constructor. make Board and 2 players, set mouse listener
   // (which is how anyone plays so far)
   public TTT()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("TicTacToe");
      
      
       player = new Player[2];
       player[0] = new Player( 'x',this );
       player[1] = new ComputerPlayer( 'o',this );
       
       theBoard = new Board();
       setLayout( new FlowLayout() );
       add(theBoard);
       
       addMouseListener( this );
              
       setSize(500,500);
       setVisible(true);
   }
   
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   @Override public void mousePressed ( MouseEvent m ) {}
   @Override public void mouseReleased( MouseEvent m ) {}
   
   // when someone clicks on a Board Square, the player whose
   // turn it is plays on that square (if available ...)
   @Override
   public void mouseClicked( MouseEvent m )
   {
      System.out.println("mouse at "+m.getX()+" "+m.getY());
      Square sq = theBoard.squareAt( m );
      if ( sq != null )
      {
         //sq.mark = 'z'; // debugging
         theBoard.play( sq, player[theBoard.whoseTurn()]);
      }
      repaint();
   }

   // paint.  draw the board
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theBoard.drawMe(g);
   }
   
   public Board getTheBoard() { return theBoard; }
}
