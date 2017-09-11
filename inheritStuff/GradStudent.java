package inheritStuff;
// GradStudent.java

import java.util.StringTokenizer;

public class GradStudent extends Student
{
	protected String adviser;

	// constructor, takes lastname, firstName (and sets credits to 100)
	public GradStudent( String ln, String fn, String adv )
	{
		super( 100, ln, fn ); // Grad students always start with 100 credits
		
		adviser = adv;
	    //lastName = ln; // not as good as using contructor, but ... shows access
	    //firstName = "bob"; private, no access
	}
	
	// constructor, expects StringTokenizer with firstName, lastName and 
	// advisorName on it
	public GradStudent( StringTokenizer st )
	{
		super( 100, "", "" ); // note: super call has to happen before we have 
		                      // extracted the data from st, so it's sort of empty.
		firstName = st.nextToken();
		lastName = st.nextToken();
		adviser = st.nextToken();
	}
	
	@Override
   public void report()
   {
      super.report();
      System.out.println("adviser="+adviser );
   }
	
	public String getAdviser() { return adviser; }

}
