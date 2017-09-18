// Student.java


package inheritStuff;

import java.util.*;

public class Student// implements StudentIF
{
	public int credits; // credit hours completed
	protected String lastName;
	protected String firstName; 
	
	// constructor
	public Student( int c, String ln, String fn )
	{
		credits = c;
		lastName = ln;
		firstName = fn;
	}
	
	// constructor, expects StringTokenizer with firstName, lastName and credits on it
	public Student( StringTokenizer st )
	{
		firstName = st.nextToken();
		lastName = st.nextToken();
		credits = Integer.parseInt( st.nextToken() );
	}
	
	// methods for the StudentIF interface
	public void sleep()
	{
		System.out.println("zzzzzzzzzzzzzzz");
	}
	public void eat() {}
	public void study() {}
	
	public void report()
	{
		System.out.println("student "+firstName+" "+lastName+" has "+credits+" credits.");
	}
	
	public void setLastName ( String ln ) { lastName  = ln; }
	public void setFirstName( String fn ) { firstName = fn; }
	
	public String getLastName() { return lastName; }
	public String getFirstName() { return firstName; }
	public int getCredits() { return credits;  }
}
