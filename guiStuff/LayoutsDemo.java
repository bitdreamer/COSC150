// Layouts.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster
// Demo of GridLayout, BorderLayout, some use of panels

package guiStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutsDemo extends JFrame
{
   JPanel panel0; // upper left of 2x2 main grid
   JPanel panel1; // upper right of 2x2 main grid
   JPanel panel2; // lower left of 2x2 main grid
   
   public static void main( String[] args )
   {
      new LayoutsDemo();
   }
   
   // constructor
   public LayoutsDemo()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      setLayout( new GridLayout( 2,2 )); // whole window
      
      panel0 = new JPanel();
      panel0.setBackground( Color.yellow );
      add(panel0);  // this.add ...
      panel0.setLayout( new BorderLayout() );
      panel0.add( new JButton("CA"), BorderLayout.WEST );
      panel0.add( new JButton("MN"), BorderLayout.NORTH );
      panel0.add( new JButton("DC"), BorderLayout.EAST );
      panel0.add( new JButton("OH"), BorderLayout.CENTER );
      panel0.add( new JButton("TX"), BorderLayout.SOUTH );
      
      panel1 = new JPanel();
      panel1.setBackground( Color.pink );
      panel1.setLayout(new FlowLayout());
      add(panel1);
      panel1.add(new JButton("dog") );
      panel1.add(new JButton("cat") );
      panel1.add(new JButton("aardvark") );
      panel1.add(new JButton("zebra") );
     
      panel2 = new JPanel();
      panel2.setBackground( new Color( 200, 100, 200 ) );
      add(panel2);
      panel2.setLayout( new GridLayout( 4, 3 ) );
      for (int i=0; i<10; i++ ) { panel2.add( new JButton(""+i) ); }
      
      add( new JButton("blah"));
      
      setSize( new Dimension( 500,500 ) );
      setVisible(true); // keep this line at the end of the constructor
      
   }
}
