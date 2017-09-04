package complex;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest
{

   @Test
   public void test()
   {
      Complex x = new Complex(3,4);
      Complex y = new Complex(5,12);
      x.plusEquals( y );
      assertTrue("real part of sum", x.real==8);
      assertTrue("imaginary part of sum",x.imag==16);

     
   }

}
