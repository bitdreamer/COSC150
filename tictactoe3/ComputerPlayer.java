package tictactoe3;

public class ComputerPlayer extends Player
{
   Thread t; // this is the thing that makes this player go
/*   
   // constructor, 1 arg , going away
   public ComputerPlayer( char m )
   {
      super(m);
      
      t = new Thread( new CPrunner() );
      t.start();
   }
*/   
   // constructor, 2 args, char to play, and the whole game
   public ComputerPlayer( char m, TTT tg )
   {
      super(m,tg);
      
      t = new Thread( new CPrunner() );
      t.start();
   }
   
   // call this to make the computer take its turn.
   // needs to check first to see if it IS this player's turn.
   public void takeTurn()
   {
      //System.out.println("I don't know how to take my turn."); // stub
      
      // is this my turn?
      Board theBoard = theGame.getTheBoard();
      int whoseTurn = theBoard.whoseTurn();
      if( theGame.player[whoseTurn]==this ) // if it's my turn ...
      {
         Square s = theBoard.pickASquare();
         theBoard.play(s,this);
         theGame.repaint();
      }
      
   }
   
   // class to ping this player every second to see if it's
   // time to play (my turn)
   class CPrunner implements Runnable
   {
      public void run()
      {
         while ( true )
         {
            try
            {
               Thread.sleep(1000);
               takeTurn();
            }
            catch(Exception e ) {}
         }
      }
   }
}
