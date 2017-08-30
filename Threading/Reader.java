// Reader.java
// part of the ReadersWriters solution


package Threading;

public class Reader implements Runnable
{
	protected ReadersWriters rw; // points to the framework object
	protected int readerID; // unique id number for this reader
	static int readerIDMax = 0;  // 
	
   @Override
   public void run()
   {
	   while ( true)
	   {
		   rw.snore(3);
		   System.out.println("reader "+readerID+" wants to read.");
		   try
		   {
			   synchronized(rw.mutex) // entry code gate, if 1st reader is hung up
			                          // waiting for writeLock, the rest of the readers
			                          // hang up here.
			   {
				   System.out.println("reader "+readerID+" checking readerCount ..."  );
				   if ( rw.readerCount==0 )
				   {
					   rw.writeLock.acquire(); // first reader grabs write lock,
					                           // waits if writer is writing
				   }
				   // else (not 1st) just pass through: if a reader is already reading,
				   // this reader just joins them.
				   rw.readerCount++; 
				   System.out.println("reader "+readerID+" starts reading, readerCount="
				              +rw.readerCount);
			   }
			   rw.snore(2); // simulate time to read
			   
			   synchronized(rw.mutex) // exit code gate
			   {
				   rw.readerCount--;
				   System.out.println("reader "+readerID+" stoping reading, readerCount="
				              +rw.readerCount);
				   if ( rw.readerCount==0 )
				   { rw.writeLock.release(); } // last reader out releases writeLock
			   }
		   }
		   catch(Exception e)
		   {System.out.println("reader "+readerID+" error=" +e);}
	   }
   }
   
   
   // constructor 
   public Reader( ReadersWriters rw1 )
   {
	   rw = rw1;
	   readerID = readerIDMax++; 
   }
}
