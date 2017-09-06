//PlayWithList.java
//Barrett Koster 2016 for COSC-150
//demo for lists

package complex;

import java.util.*; // import java.util.LinkedList;

public class PlayWithList
{
   // protected LinkedList<Complex> wave;
   protected LinkedList wave;
   
   
   public static void main( String[] args )
   {
      new PlayWithList();
   }
   
   PlayWithList()
   {
   //   wave = new LinkedList<Complex>();
      wave = new LinkedList();
      
      wave.add( new Complex( 3,4 ) );
      wave.add( new Complex( 2, 0 ) );
      wave.add( new Complex( 5, 12 ) );
     
   //   Iterator <Complex> it = wave.iterator();
      Iterator it = wave.iterator();
      while ( it.hasNext() )
      {
         Complex c = (Complex)it.next();
         System.out.println("magnitude is "+c.mag() );
      }
   }
}
