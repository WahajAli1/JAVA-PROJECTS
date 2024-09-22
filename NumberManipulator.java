// Write code which displays two buttons in gui window and a number in output section
// If first button is pressed, the number is increased
// If second button is pressed, the number is decreased

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberManipulator {

    private int number = 0;
    private JLabel numberLabel;

    public static void main(String[] args) {
        // Create an instance of the class to initialize the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberManipulator().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        // Step 1: Create a JFrame
        JFrame frame = new JFrame("Number Manipulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Step 2: Create Components
        numberLabel = new JLabel(String.valueOf(number), SwingConstants.CENTER);
        JButton increaseButton = new JButton("Increase");
        JButton decreaseButton = new JButton("Decrease");

        // Step 3: Add action listeners to the buttons
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                updateNumberLabel();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number--;
                updateNumberLabel();
            }
        });

        // Step 4: Add components to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(increaseButton);
        buttonPanel.add(decreaseButton);

        frame.add(numberLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Step 5: Display the frame
        frame.setVisible(true);
    }

    private void updateNumberLabel() {
        numberLabel.setText(String.valueOf(number));
    }
}
