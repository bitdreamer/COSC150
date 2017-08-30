// Bounce.java
// Barrett Koster 2016
// simple animaiton demo

package guiStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce extends JFrame
   implements ActionListener
{
	Timer clicky;
	Ball[] balls;
	int ballCount;
	double deltat = 0.1; //  in seconds
	
	public static void main( String[] args )
	{
		new Bounce();
	}
	
	public Bounce()
	{
		System.out.println("Bounce: starting ... ");
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setTitle("Bounce");
		setBackground( Color.WHITE );
		
		//setDoubleBuffered(false);
		
		ballCount = 10;
		balls = new Ball[100];
		for ( int i=0; i<ballCount; i++ ) { balls[i] = new Ball(); }
		
		clicky = new Timer((int)(1000 * deltat), this);
		clicky.start();
		
		addMouseListener(
				new MouseAdapter()
				{	    public void mouseClicked( MouseEvent m )
					    {
					         balls[ballCount++] = new Ball( m.getX(), m.getY() );
					    }
				}
				        );
		
		setSize( 600,600 );
		setVisible(true);
	}
	
	public void actionPerformed( ActionEvent e )
	{
		System.out.println("click");
		if ( e.getSource()==clicky ) { moveAll(); }
		repaint();
	}
	
	@Override
	public void paint( Graphics g )
	{
		//super.paint(g); takes too long
		g.setColor( Color.WHITE ); // just white-out the window
		int w = getWidth();  int h = getHeight();
		g.fillRect( 0, 0, w, h );  // with a big rectangle
		
		for ( int i=0; i<ballCount; i++ ) { balls[i].drawMe(g); }

	}
	
	public void moveAll()
	{
		for ( int i=0; i<ballCount; i++ ) { balls[i].move(deltat); }
	}

	public class Ball
	{
		double x, y;
		double vx, vy;
		double oldx, oldy;
		
		public Ball( int x1, int y1 )
		{
			x = x1; y = y1; 
			vx = Math.random() * 100 - 50;
			vy = Math.random() * 100 - 50;
		}
		
		public Ball()
		{
			x = Math.random() * 400 + 100;
			y = Math.random() * 400 + 100;
			vx = Math.random() * 100 - 50;
			vy = Math.random() * 100 - 50;
		}
		
		public void move( double deltat )
		{
			oldx = x; oldy = y;
			x += vx * deltat;
			y += vy * deltat;
			stayOnScreen();
		}
		public void stayOnScreen()
		{
			if ( x<0 ) { vx *= -1; }
			if ( y<0 ) { vy *= -1; }
			if ( x>550 ) { vx *= -1; }
			if ( y>550 ) { vy *= -1; }
		}
		
		public void drawMe( Graphics g )
		{
			//g.setColor( Color.WHITE ); // erase the old one
			//g.fillOval( (int)(oldx-2), (int)(oldy-2), 5, 5 );
			
			g.setColor( Color.BLACK );
			g.fillOval( (int)(x-2), (int)(y-2), 5, 5 );
		}
	}
}
