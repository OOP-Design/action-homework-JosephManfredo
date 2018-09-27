import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**This class creates a game where a circle moves around the frame as
the users cursor comes near to it.
The main method is just creating the frame and making it visible
**/
public class Circle{
  public static void main(String[] args){
      MyFrame f = new MyFrame();
      f.setVisible(true);
    }
}

/**This class holds the attributes of the frame
**/
class MyFrame extends JFrame{
    public MyFrame(){
      setSize(1000,1000);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MyPanel p = new MyPanel();
      add(p);
    }
}
/**This class holds teh implementation of the game.
The circle is created here.
The MouseMotionListener gathers the location of the mosue and its distance
from the circle. This listener is what holds the logic about when the circle moves.
**/
class MyPanel extends JPanel{
      Point MyCircle = new Point((int) (Math.random() * 800.00), (int) (Math.random() * 800.00));
      int diameter = 35;
    public MyPanel(){
      addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
              if(e.getPoint().distance(MyCircle) <= 35.00){
                  MyCircle.move((int) (Math.random() * 800.00), (int) (Math.random() * 800.00));
                  repaint();
              }
            }
      });
    }

    /**This method is what paints and repaints the circle
      @param g This parameter holds all of the methods for drawing items on the panel.
    **/
    public void paintComponent(Graphics g){
        int x = (int) MyCircle.getX();
        int y = (int) MyCircle.getY();
        g.setColor(Color.RED);
        g.fillOval(x,y,diameter,diameter);
    }

}
