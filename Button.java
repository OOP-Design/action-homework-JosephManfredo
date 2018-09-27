
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/** This class prints the character gathered from the keyboard on the frame and
clears the frame on a right click.
The main method is just creating the frame and making it visible
**/
public class Button{
  public static void main(String[] args){
      MyFrame f = new MyFrame();
      f.setVisible(true);
    }
}

/** This class holds the attributes of the frame
The KeyListener is what listens to the keyboard input.
That string is then add to an ArrayList in the panel.
The MouseListener is what listens for the right click to clear the frame.
**/
class MyFrame extends JFrame{
    public MyPanel p = new MyPanel();

    public MyFrame(){
      setTitle("Random Character");
      setSize(600,600);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(p);
    addKeyListener(new KeyAdapter(){
      public void keyPressed(KeyEvent e){
         String s = e.getKeyText(e.getKeyCode());
         p.addChar(s);
        }
    });

    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        p.reset(e.getButton());
      }
    });
  }
}

/** This class holds the implementation of the data gathered from the JFrame
The ArrayLists hold the strings and their points.
**/
class MyPanel extends JPanel{
  private ArrayList<String> charArray = new ArrayList<String>();
  private ArrayList<Point> pointArray = new ArrayList<Point>();
  private int i = 0;

  public MyPanel(){
      super();
    }
  /** This method adds a given string to the ArrayList
  holding the strings and assigns the string a random point.
  @param s This is the string that is to be added to the ArrayList
  **/
  public void addChar(String s){
      charArray.add(i,s);
      pointArray.add(i, randomPoint());
      i++;
      repaint();
  }

  /** This method creates point objects
  **/
  public Point randomPoint(){
      return new Point((int) (Math.random() * 450), (int) (Math.random() * 450));
  }

  /** This method is the implementation of the frame clear.
  It checks for a right mouse click then clears the board.
  @param button This integer is the number assigned to the different buttons on the mouse
  **/
  public void reset(int button){
      if(button == 3){
        pointArray.clear();
        charArray.clear();
        i = 0;
        repaint();
      }
  }

    /** This method is an abstract method of JPanel and is overwritten here.
    This method iterates through the two ArrayLists and paints the strings at
    their assigned points.
    @param g This parameter holds all of the methods for drawing items on the panel.
    **/
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      int counter = 0;
      Point mypoint;
      while(counter < charArray.size()){
        mypoint = pointArray.get(counter);
        g2.drawString(charArray.get(counter), (int) mypoint.getX(), (int) mypoint.getY());
        counter++;
      }
    }
}
