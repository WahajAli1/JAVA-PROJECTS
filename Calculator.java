import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Define components
    private JTextField display;
    private JPanel panel;
    private String[] buttons = {
        "7", "8", "9", "/", 
        "4", "5", "6", "*", 
        "1", "2", "3", "-", 
        "0", ".", "=", "+"
    };
    private JButton[] buttonArray = new JButton[buttons.length];

    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";
    private boolean startNewNumber = true;

    public Calculator() {
        // Initialize frame
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Initialize panel and buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        for (int i = 0; i < buttons.length; i++) {
            buttonArray[i] = new JButton(buttons[i]);
            buttonArray[i].setFont(new Font("Arial", Font.PLAIN, 32));
            buttonArray[i].addActionListener(this);
            panel.add(buttonArray[i]);
        }
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".indexOf(command) != -1) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if ("+-*/".indexOf(command) != -1) {
            if (!operator.isEmpty()) {
                operand2 = display.getText();
                double result = calculate(Double.parseDouble(operand1), Double.parseDouble(operand2), operator);
                display.setText("" + result);
                operand1 = "" + result;
            } else {
                operand1 = display.getText();
            }
            operator = command;
            startNewNumber = true;
        } else if (command.equals("=")) {
            operand2 = display.getText();
            double result = calculate(Double.parseDouble(operand1), Double.parseDouble(operand2), operator);
            display.setText("" + result);
            operator = "";
            startNewNumber = true;
        }
    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand1 / operand2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
