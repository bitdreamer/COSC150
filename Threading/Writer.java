// Writer.java
// part of the ReadersWriters demo

package Threading;

public class Writer implements Runnable
{
   protected ReadersWriters rw; // pointer to driving class with the locks in it
   protected int writerID; // unique for writers
   protected static int writerIDMax=0; // number of IDs given so far
   
   // do this when you 'start' the Thread
   public void run()
   {
	   while (true) // simulate writer coming to write over and over
	   {
		   rw.snore(3); // random delay, simulate non-writing phase
		   
		   System.out.println("writer "+writerID+" wants to write.");
		   try
		   {		   
			  rw.writeLock.acquire(); // get permit, wait until available as needed
			   System.out.println("writer "+writerID+" first write.");
			  rw.snore(1); // simulates the time to write
			   System.out.println("writer "+writerID+" last write.");
			  rw.writeLock.release(); // put permit back so others can use it
		   }
		   catch(Exception e)
		   {System.out.println("writer "+writerID+" error=" +e);}
	   }
   }
   
   // constructor, needs access to controlling ReadersWriters frame,
   // particularly the locks inside of it.
   // also set ID.
   public Writer( ReadersWriters rw1 )
   {
	   rw = rw1;
	   writerID = writerIDMax++;
   }
}
