package TTTwithC1;

public class ComputerPlayer extends Player
{
   Thread flapper;
   
   public ComputerPlayer( char m, Board tb )
   {
      super(m,tb);
      
      flapper = new Thread( new CPgo() );
      flapper.start();
   }
   
   @Override
   // if it's my turn, take it.  If not, do nothing.
   public void takeTurn()
   {
      if (theBoard.myTurn()==this)
      {
         Square sq = theBoard.pickEmpty();
         theBoard.play( sq, this );
      }
   }
   
   public class CPgo implements Runnable
   {
      public void run()
      {
         while ( true )
         {
            try
            {
               Thread.sleep(2000);
               takeTurn();
            }
            catch(Exception e){}
         }
      }
   }
}
