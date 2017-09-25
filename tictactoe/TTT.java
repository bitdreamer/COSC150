// TTT.java
// COSC-150 fall 2017

package tictactoe;

import java.awt.*;
import javax.swing.*;

public class TTT extends JFrame
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
       
       setSize(500,500);
       setVisible(true);
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theBoard.drawMe(g);
   }
}
