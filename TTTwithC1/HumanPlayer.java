package TTTwithC1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HumanPlayer extends Player
{
   public HumanPlayer( char m, Board tb )
   {
      super(m,tb);
   }
   
   @Override
   public void takeTurn()
   {
      JOptionPane.showMessageDialog( null, "take your turn" );
   }
}
