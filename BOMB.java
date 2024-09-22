import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BOMB 
{
    public static void main(String[] args) 
    {
        JFrame f = new JFrame("BOMB");
        FlowLayout fl = new FlowLayout();
        JButton B = new JButton("PRESS AT YOUR OWN RISK!");
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSplashBombs();
            }
        });
        f.setLayout(fl);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(B);
        f.setVisible(true);
    }

    private static void createSplashBombs() 
    {
        for (int i = 0; i < 10; i++) 
        {
            JFrame splashFrame = new JFrame("Splash " + (i + 1));
            splashFrame.setSize(300, 300);
            splashFrame.setLocation(50 + (i * 80), 50 + (i * 80));
            splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            splashFrame.setVisible(true);
        }
    }
}