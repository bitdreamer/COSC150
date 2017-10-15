package TTTwithC1;

public class Player
{
   char mark; // this is the player's mark, x or o
   Board theBoard;
/*   
   // constructor, needs 1 argument which is x or o
   public Player( char m )
   {
      mark = m;
   }
   */
   // constructor, needs 2 arguments, which is x or o,
   // theBoard
   public Player( char m, Board tb )
   {
      mark = m;
      theBoard = tb;
   }
   
   // you call this method to tell this player to take
   // their turn.
   public void takeTurn()
   {
   }
   
   
   // turn method ...?
   public char getMark() { return mark; }
}
