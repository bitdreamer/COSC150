//Complex.java
//class for complex numbers (real,imaginary).

package complex;

public class Complex 
{
   protected double real;
   protected double imag;

   // constructor
   public Complex()
   {
      real = imag = 0;
   }
   
   // constructor, copies argument into this number
   public Complex( Complex c )
   {
      real = c.real;
      imag = c.imag;
   }
   
   // constructor from doubles
   public Complex( double r, double i )
   {
      real = r;
      imag = i;
   }
   
   // returns the magnitude of the complex number
   public double mag()
   {
      return Math.sqrt(real*real + imag*imag);
   }
   
   // sets magnitude to 1, keeps direction
   // should throw divide by 0 exception if it's zero
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
   
   public static void main ( String[] args )
   {
       System.out.println("Complex.main ...");
       Complex x = new Complex(3,4);
       Complex y = new Complex(5,12);
       x.plusEquals( y );
       System.out.println("x is now "+x.real+" "+x.imag);
   }
}