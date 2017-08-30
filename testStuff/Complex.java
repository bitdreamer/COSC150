package testStuff;
/** Complex.java is a class that implements complex
 *  numbers (real, imaginary).
 *  @author Barrett Koster
 *  
*/

public class Complex
{
   protected double real;
   protected double imag;
   
   // you can use main to test your class
   public static void main ( String[] args )
   {
	   System.out.println("Complex.main ...");
	   Complex z = new Complex();
	   Complex x = new Complex( 3,4 );
	   Complex y = new Complex( 5, 12 );
	   x.plusEquals( y );
	   System.out.println("x is now " +x.real+" "+x.imag);
	   
	   
	   z.normalize(); // should crash
   }
   
   /**
    * constructor takes no args, generated object is 0,0
   */
   // constructor
   public Complex()
   {
	   real = imag = 0;
   }
   
   /** constructor, copies argument into this number
    * 
    * @param c funciton makes a copy of this argument
    */
   public Complex( Complex c )
   {
	   real = c.real;
	   imag = c.imag;
   }
   
   /** constructor from doubles, 
    * @param r the real part of the number to be made
    * @param i the imaginary part to put in the new Complex number
    */
   public Complex( double r, double i )
   {
	   real = r;
	   imag = i;
   }
   
   /** @return the magnitude of the complex number
    */
   public double mag()
   {
	   return Math.sqrt(real*real + imag*imag);
   }
   
   /** 
    * sets magnitude to 1, keeps direction
    * @throws should throw divide by 0 exception if it's zero
    */
   public Complex normalize()
   {
	   double mag = mag();
	   if ( mag == 0 ) { throw new ArithmeticException(); }
	   real /= mag;
	   imag /= mag;
	   return this;
   }
   
   
   // add the argument into THIS number, also return this
   public Complex plusEquals( Complex c )
   {
	   real += c.real;
	   imag += c.imag;
	   return this;
   }
   
   
}
