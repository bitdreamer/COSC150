// PartishPart.java

package stingy;
		   
// PartishPart holds the information for one section of the partition
public class PartishPart
{
	   protected int id; // number from the original int[] orig
	   protected int count; // how many times does this number appears in the orig set
	   
	   // constructor, give it the number we are looking
	   public PartishPart( int id1 )
	   {
		   id = id1;
		   count = 1;  
	   }
	   
	   public void addOne() { count++; }
	   
	   public int getId() { return id; } 
	   public int getCount() { return count; }
	  
}
