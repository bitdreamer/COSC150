// Layouts.java
// practice with basic GUI elements, event listener
// CS-212 2014 with Barrett Koster

package guiStuff;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo extends JFrame implements ActionListener
{
   JButton dogButton;
   JButton catButton;
   
   public static void main( String[] args )
   {
      new EventDemo();
   }
   
   // constructor
   public EventDemo()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      
      setLayout( new FlowLayout() );
      
      dogButton = new JButton("dog"); // makes the object
      add(dogButton); // adds it to the window
      dogButton.addActionListener(this); // so when you press on it, something happens
      
      catButton = new JButton("cat");
      add(catButton);
      catButton.addActionListener(this);
      
      setSize( new Dimension( 200,200 ) );
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      System.out.println("you rang?");
      if      ( e.getSource()==dogButton ) { System.out.println("bow wow"); }
      else if ( e.getSource()==catButton ) { System.out.println("meow"); }
      
      repaint();
   }
}
