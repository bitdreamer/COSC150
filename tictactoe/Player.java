package tictactoe;

public class Player
{
   char mark; // this is the player's mark, x or o
   
   // constructor, needs 1 argument which is x or o
   public Player( char m )
   {
      mark = m;
   }
   
   public char getMark() { return mark; }
   // turn method ...?
}
