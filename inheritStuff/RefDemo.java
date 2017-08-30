// RefDemo.java

package inheritStuff;

import java.util.*;

// RefDemo.java
// 2016 for COSC-150
// Demo for call by reference v. call by value, and wrappers


public class RefDemo {
	
	public static void main( String[] args )	{
		new RefDemo();
	}
	
	public RefDemo()	{
		Student s1 = new Student( 34, "Smith", "Jane" );
		s1.report(); 
		
		Student s2 = new GradStudent( "Jones", "Pete" );
        s2.report();
        
        System.out.println("Pete takes courses.");
        s2.credits += 20;
        s2.report();
        
        System.out.println("Pete gets married and changes lastName");
        // s2.lastName = s2.lastName + "-Hall";
        s2.setLastName( s2.getLastName()+"-Hall");
        s2.report();
        
        //s2.firstName = "Petronius";
        s2.setFirstName("Petronius");
	}

	public void readStudentFile()
	{
		// ....
		String s; // say this is from a line ine the file ....
		
		StringTokenizer st = new StringTokenizer(s);
		String s1 = st.nextToken();
		String s2 = st.nextToken();
	}

	
}
