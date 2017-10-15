// TTT.java
// COSC-150 fall 2017

package TTTwithC1;

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
   
   // constructor. make Board and 2 players, set mouse listener
   // (which is how anyone plays so far)
   public TTT()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("TicTacToe");
      
      Board.setTheGame(this );

      player = new Player[2];
      theBoard = new Board( player );
      setLayout( new FlowLayout() );
      add(theBoard);
      
       player[0] = makePlayer( 'x' );
       player[1] = makePlayer( 'o' );
       
       
       addMouseListener( this );
              
       setSize(500,500);
       setVisible(true);
   }
   
   // return a new Player object with m as the mark
   public Player makePlayer( char m )
   {
      Player p = null;
      
      while ( p==null )
      {
         String horc = JOptionPane.showInputDialog(
               "player of "+m+"is human or computer? (h/c) : ");
         
         if      ( horc.equals("h")) { p = new HumanPlayer   ( m, theBoard ); }
         else if ( horc.equals("c")) { p = new ComputerPlayer( m, theBoard ); }
      }
      return p;
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
   
   
}
