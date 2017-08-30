package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Die extends JPanel
   implements MouseListener
{
	int showing; // top face when rolled, 1-6
	
	public static void main( String[] args )
	{
		JFrame driver = new JFrame();
		driver.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		driver.setLayout( new FlowLayout() );
		driver.add( new Die() );
		
		driver.setSize(200,200 );
		driver.setVisible(true);
	}
	
   public Die()
   {
	   setPreferredSize( new Dimension(50,50)  );
	   setBackground( Color.yellow );
	   addMouseListener( this );
   }
   
   public void mouseClicked( MouseEvent m ) 
   {
	   System.out.println("mouse clicked");
	   setBackground( new Color(200,100,100) );
	   repaint();
   }
   public void mouseEntered( MouseEvent m ) {}
   public void mouseExited ( MouseEvent m ) {}
   public void mouseReleased( MouseEvent m ) {}
   public void mousePressed( MouseEvent m ) {}
   
   public void paint( Graphics g )
   {
	   super.paint(g);
	   
   }
   
}
