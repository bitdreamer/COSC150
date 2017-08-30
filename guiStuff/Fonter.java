// Fonter.java
// BEK 2017 ... trying to print Chinese

package guiStuff;

import java.awt.*;
import javax.swing.*;

public class Fonter extends JFrame
{
   Font theFont;
   
	public static void main( String[] args )
	{
		new Fonter();
	}
	
	public Fonter()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(800,800);
		setVisible(true);
	}
	
	public void paint( Graphics g )
	{
		super.paint(g);
		theFont = new Font("TNR",0,50);
		g.setFont(theFont);
		String s = "\u2f20";
		g.drawString(s, 100, 100); // works!

		int i3 = 0x2f21;
		String s3 = "";
		for ( int i=0; i<100; i++ )
		{
		    s3 = Character.toString((char)i3);
		    g.drawString(s3,100 + 60 * (i%10), 200 + 60 * (i/10)  );
		    i3++;
		}
		
	}
}
