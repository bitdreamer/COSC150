package formatting;

import java.text.DecimalFormat;

public class formatStuff
{
   public static void main ( String[] args )
   {
	   System.out.println("pi="+ Math.PI   );
	   
	   double pi = Math.PI;
	   
	   DecimalFormat df;
	   df = new DecimalFormat("#.###");
	   
	   System.out.println("pi="+ df.format(pi) );
	   
   }
}
