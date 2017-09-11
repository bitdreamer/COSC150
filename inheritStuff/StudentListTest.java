package inheritStuff;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentListTest
{

   @Test
   public void test1()
   {
      Student s1 = new Student( 34, "Smith", "Jane" );
      s1.report(); 
      
      assertTrue("Student.firstName storage ", s1.getFirstName().equals("Jane") );
      assertTrue("Student.lastName storage " , s1.getLastName().equals("Smith") );
      assertTrue("Student.credits storage"   , s1.getCredits() == 34 );
   }
   
   @Test
   public void test2()
   {
      GradStudent s1 = new GradStudent("Jones","Pete","Knuth");
      s1.report();
      
      assertTrue("Student.firstName storage ", s1.getFirstName().equals("Pete") );
      assertTrue("Student.lastName storage " , s1.getLastName().equals("Jones") );
      assertTrue("Student.adviser storage "  , s1.getAdviser().equals("Knuth") );
      assertTrue("Student.credits storage"   , s1.getCredits() == 100 );

   }
   
   @Test
   public void testTheList()
   {
      StudentList sl = new StudentList();
      
      // fix - I want to hard-code the data file name, and then ... it should
      // make a list of 5 students I think.  Let's test for that.
   }

}
