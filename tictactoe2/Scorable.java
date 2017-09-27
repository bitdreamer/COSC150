package tictactoe2;

// This is row, column or diagonal that can become a win.

public class Scorable
{
   Square[] square; // you must capture all of these Squares to win
   int numDefined; // how many Squares we have so far (it starts empty, 
                   // ends up being filled out AFTER constructor)
   
   // constructor, start list empty
   public Scorable()
   {
      square = new Square[ Board.getBoardSize() ];
      numDefined = 0;
   }
   
   // add a Square to the array.  This is part of initialization
   // but can't be done in the constructor
   public void addSquare( Square sq )
   {
      square[numDefined++] = sq;
   }
   
   // return character of winner if any, just a space if no one wins
   public char win()
   {
      char w = ' '; // assume no one wins unless you find one
      
      boolean allSameOwner = true; // start with true but one vacancy knocks it false
      char m = square[0].getMark(); // first character in the row ...
      if ( m==' ') { allSameOwner = false; }
      else
      {
         for ( int i=1; allSameOwner && i<Board.getBoardSize(); i++ )
         {
            allSameOwner = allSameOwner && ( m==square[i].getMark() );
         }
      }
      
      if (allSameOwner) { w = m; }
      
      return w;
   }
   
}
