// ThreadDemoV3.java
// This is a threading demo.  It creates a bunch of Counter
// objects, each of which counts (and prints out numbers)
// at its own random pace (to a given maximum).

package Threading;

public class ThreadDemoV3
{
	protected int counterCount=3;
	
	protected Counter[] counterArray;
	
	public static void main( String [] args )
	{
		new ThreadDemoV3();
	}
	
	// constructor
	public ThreadDemoV3()
	{
		counterArray = new Counter[counterCount];
		for ( int i=0; i<counterCount; i++ )
		{
			counterArray[i] = new Counter(i);
		}
		for ( int i=0; i<counterCount; i++ )
		{
			//counterArray[i].start(); // don't call "run" or you don't get a thread.
			new Thread( counterArray[i] ).start(); // this one is for Counter Runnable not Thread
		}
	}
	public class Counter /*  extends Thread */ implements Runnable
	{
	     int id; // this processes id

	    public Counter( int id1 )
	    {
	       	id = id1;
	    }
	    
	    @Override
	    public void run()
	    {
		    	for ( int j=0; j<10; j++ )
		    	{
		    		System.out.println("the count in Counter "+id+" is "+j);
		    		try
		    		{
		    		   Thread.sleep((int)(Math.random()*100));
		    		}
		    		catch(Exception e) { System.out.println("insomnia"); }
		    	}
	    }
	}
}
