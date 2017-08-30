// StudentList.java
// COSC-150
// Holds a bunch of student records

package inheritStuff;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class StudentList
{
   LinkedList<Student> students; // attribute, once class is created it exists, can be 
                                 // used later
   
   public static void main( String[] args )
   {
	   new StudentList();
   }
   
   // constructor, reads a file of students and loads them onto the list
   // and does a report() to check list contents
   public StudentList()
   {
	   String filename;
	   Scanner in = new Scanner(System.in);
	   
	   
	   System.out.print("enter file name to load : ");
	   filename = in.nextLine();
	   
	   
	   //filename = JOptionPane.showInputDialog("enter filename :");
	   
	   students = new LinkedList<Student> (); // initialize the list
	   try
	   {
		   // open the file
		   File f = new File(filename);
		   FileReader fr = new FileReader( f );
		   BufferedReader br = new BufferedReader( fr );
		   
		   // read and process lines
		   String line;
		   while ( (line = br.readLine()) != null )
		   {
			   dealWithLine( line );
		   }
		   br.close();
	   }
	   catch ( Exception e )
	   { System.out.println("file thingy: "+e); }
	   
	   in.close();
	   
	   report();
   }
   
   // Process this line from the file, expecting students 
   // definitions ...
   // Note: catch errors in line (so you can keep reading the file)
   public void dealWithLine( String line )
   {
	   try
	   {
		   System.out.println("about to process ... "+line);
		   StringTokenizer st = new StringTokenizer( line );
		   String cmd = st.nextToken();
		   if      ( cmd.equals("student") )	{ students.add( new Student(st) ); }
		   else if ( cmd.equals("grad"   ) ) { students.add( new GradStudent(st) ); }
	   }
	   catch (NoSuchElementException n) {}
	   catch (Exception e )
	   { System.out.println("error in this line " +e);
	   }
   }
   
   // print out about all of the students on the list
   public void report()
   {
	  Iterator<Student> it = students.iterator();
	  while ( it.hasNext() )
	  {
		  Student s = it.next();
		  s.report();
	  }
   }
}
