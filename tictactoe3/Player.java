package tictactoe3;

public class Player
{
   char mark; // this is the player's mark, x or o
   TTT theGame;
   
   // constructor, needs 1 argument which is x or o
   public Player( char m )
   {
      mark = m;
     
   }
   // constructor, needs 1 argument which is x or o
   public Player( char m, TTT tg )
   {
      mark = m;
      theGame = tg;
   }
   
   
   // turn method ...?
   public char getMark() { return mark; }
}
