import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

/** This class creates a window that has two menus.
One menu can close the window, and the other can change the color.
The main method is just creating the frame and making it visible
**/
public class Menu{

  public static void main(String[] args){
      MyFrame f = new MyFrame();
      f.setVisible(true);
    }
}

/** This class holds the attributes of the Frame.
It also holds the methods that create the menus and the class that hold their implementation.
**/
class MyFrame extends JFrame{
    private JPanel mypanel = new JPanel();

    public MyFrame(){
      setTitle("Menu");
      setSize(200,200);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      displayMenu();
      add(mypanel);
    }

    /** This method creates the two menus.
    **/
    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new GameMenu());
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }

    /** This class holds the implementation behind the menu that can close the window.
    **/
    private class GameMenu extends JMenu{
        public GameMenu(){
            super("Game");
            JMenuItem quitMI = new JMenuItem("Quit");

            quitMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            add(quitMI);
        }
    }

    /**This class adds the options to the color menu, and
    gives the objects listeners so implementation cna be added.
    **/
    private class ColorMenu extends JMenu{
      Color red = Color.RED;
      Color blue = Color.BLUE;
      Color green = Color.GREEN;
        public ColorMenu(){
            super("Panel Color");
            JMenuItem menuItemr = new JMenuItem("Red");
            JMenuItem menuItemb = new JMenuItem("Blue");
            JMenuItem menuItemc = new JMenuItem("Green");

            menuItemr.addActionListener(new ColorListener(Color.RED));
            menuItemb.addActionListener(new ColorListener(Color.BLUE));
            menuItemc.addActionListener(new ColorListener(Color.GREEN));
            add(menuItemr);
            add(menuItemb);
            add(menuItemc);

        }

      /**This class holds the implementation behind the options of the
      color menu.
      **/
      private class ColorListener implements ActionListener{
          private Color color;
          public void actionPerformed(ActionEvent e){
              mypanel.setBackground(color);
          }
          public ColorListener(Color color){
            this.color = color;
          }
      }
    }
  }
