import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Directions
{
    
        JFrame f = new JFrame("DIRECTIONS");
        JButton UP = new JButton("UP");
        JButton DOWN = new JButton("DOWN");
        JButton LEFT = new JButton("LEFT");
        JButton RIGHT = new JButton("RIGHT");
        FlowLayout fl = new FlowLayout();
        public Directions()
        {
        f.setLayout(fl);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(UP);
        f.add(DOWN);
        f.add(LEFT);
        f.add(RIGHT);
        UP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 10 ; i++)
                {Point currentLocation = f.getLocation();
                f.setLocation(currentLocation.x, currentLocation.y - 30);}
            }
        });
        DOWN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 10 ; i++)
                {Point currentLocation = f.getLocation();
                f.setLocation(currentLocation.x, currentLocation.y + 30);}
            }
        });
        LEFT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 10 ; i++)
                {Point currentLocation = f.getLocation();
                f.setLocation(currentLocation.x -30 , currentLocation.y);}
            }
        });
        RIGHT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 10 ; i++)
                {Point currentLocation = f.getLocation();
                f.setLocation(currentLocation.x +30 , currentLocation.y);}
            }
        });
        f.setVisible(true);
       
}
public static void main (String [] args)
    {
        Directions g = new Directions();}
    }