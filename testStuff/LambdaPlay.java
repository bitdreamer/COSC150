package testStuff;
// LambdaPlay.java
// example of use of Lambda expressions to be able to pass functions
// as arguments.

import java.util.*;

public class LambdaPlay
{
	// the StringModifier interface is place-holder for functionality.
	// We can make specific classes for this Interface that have
	// certain functionality for apply(), then make Objects from those
	// classes, and then pass those objects around as way of passing
	// the functionality.
    interface StringModifier
    {
	   String apply(String s);
    }
    
    // convertCase takes String and StringModifier and returns
    // the result of doing StringModifier's one method on the String.
    // This lets us perform a particular function by passing that
    // function as an argument.  
    // I.e., once we have created a specific StringModifier Object
    // to do some particular function, this is how we get it 
    // to do it.
    public static String convertCase(String s, StringModifier sm) {
        return sm.apply(s);
    }
        
    // This method takes a list of Strings and an Object meeting the
    // StringModifier interface, and it prints out the list,
    // first using the modifier on each string.
    // This is an example of some work we'd like to do, where some 
    // functional part of it (here, case conversion) is now passed
    // in as an argument.
    static public void printListWithCase( 
    		Vector<String> myStrings, StringModifier sm )
    {
		for (String s : myStrings) {
		    System.out.println( convertCase( s, sm) );
		}    	
    }
 
    // demo of how to use StringModifier with Lambda expressions
    public static void main( String[] args ) {
		Vector<String> myStrings = new Vector<String>();
		myStrings.add("Hello");
		myStrings.add("World");
		myStrings.add(" and such ");
		
		// Here's the call the way we want to do it, 
		printListWithCase( myStrings, s -> s.toUpperCase() );
		printListWithCase( myStrings, s -> s.toLowerCase() );
		// The lambda expression "s -> s...." returns an Object which
		// implements the StringModifier interface, in particular with the
		// apply function filled in with toUpperCase or toLowerCase
		// as specified.  
    }
}
