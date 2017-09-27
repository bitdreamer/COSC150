// TTT.java
// COSC-150 fall 2017

package tictactoe;

import java.awt.*;
import java.awt.event.*;
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
   
   // constructor
   public TTT()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("TicTacToe");
      
       player = new Player[2];
       player[0] = new Player( 'x' );
       player[1] = new Player( 'o' );
       
       theBoard = new Board();
       
       addMouseListener(this);
       
       setSize(500,500);
       setVisible(true);
   }
   
   // Mouse Handler stuff
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   @Override public void mousePressed ( MouseEvent m ) {}
   @Override public void mouseReleased( MouseEvent m ) {}
   @Override public void mouseClicked ( MouseEvent m )
   {
      System.out.println("mouse at "+m.getX()+" "+m.getY());
      Square sq = theBoard.findSquare( m );
      
      if ( sq!=null )
      {
         if ( sq.getMark()==' ' )
         {
            sq.setMark(player[theBoard.whoseTurn()].getMark());
            theBoard.winner();
         }
      }
      repaint();
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theBoard.drawMe(g);
   }
}
