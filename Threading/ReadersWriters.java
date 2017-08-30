// ReadersWriters.java
/*
 This is a demo of the classic Readers and Writers problem.  
  There is a file that processes want to read and write.
  We want to allow only one writer at a time (and no
  readers when they are) or a bunch of readers.
  
  The writer code is pretty straight forward, get the lock
  to write, put it back when done, wait for it if in use.
  
  The Reader code is a little more complex.  The first Reader
  grabs the lock, but the rest just pile on.  We keep a 
  Reader count, so when the last one is leaving, we can give
  the lock back.  Final note: mutex protects the entry and exit
  code for the Readers, so the count doesn't get off.
  
  Semaphore writeLock ... set to 1 (one permit to write, is acquired and released
  
  Writer()
  {
     while (true)  // simulates writer writing, leaving, coming back to write more
     {
        do other stuff
        writeLock.acquire(); // first writer here gets it, next writer hangs
        write for a while
        writeLock.release(); // available for another writer
     }
  }

  readerCount = 0;
  
  Reader()
  {
     while (true) // read, leave, come back and read some more
     {
        do other stuff
        sync mutex // entry code, only one at a time so no confusion
        {
           if (readerCount==0 ) { writeLock.acquire() } // first reader in blocks writers
           readerCount++
        }
        read for a while
        sync mutex // this sync under same control as the other
        {
           if (readerCount==1) { lockw.notify(); } // last reader out frees permit for writers
           readerCount--
        }
     }
  }
  
  
 */

package Threading;

import java.util.concurrent.Semaphore;

public class ReadersWriters
{
    protected Object mutex; // traditional name, used in Reader code
    protected int readerCount; // number of readers in the system who are reading
    protected Semaphore writeLock; // permit for ONE writer (or some readers)
	
	public static void main ( String[] args )
	{
		new ReadersWriters();
	}
	
	// constructor, creates locks, 2 readers, 2 writers and says "go!"
	public ReadersWriters()
	{
		mutex = new Object();
		writeLock = new Semaphore(1); // ONE write permission slip to be shared
		
		Thread reader1 = new Thread( new Reader( this) );
		Thread reader2 = new Thread( new Reader( this) );		
		Thread writer1 = new Thread( new Writer(this ) );
		Thread writer2 = new Thread( new Writer(this ) );

		reader1.start();
		reader2.start();		
		writer1.start();
		writer2.start();
	}
	
	// sleep randomly up to n seconds, 
	// handles the try catch stuff needed for Thread.sleep().
	// Used to kill time to test sync
	public void snore(int n)
	{
		int howMuch = (int) ( n *1000 * Math.random() );
		try { Thread.sleep(howMuch); }
		catch (Exception e)
		{System.out.println("insomnia");}
	}
}
