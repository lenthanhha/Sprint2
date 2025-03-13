package sprint2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstDegreeEquationSolverGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("First Degree Equation Solver");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create labels
        JLabel aLabel = new JLabel("Coefficient a:");
        aLabel.setBounds(20, 20, 100, 25);
        frame.add(aLabel);

        JLabel bLabel = new JLabel("Constant b:");
        bLabel.setBounds(20, 60, 100, 25);
        frame.add(bLabel);

        JLabel resultLabel = new JLabel("Solution:");
        resultLabel.setBounds(20, 100, 100, 25);
        frame.add(resultLabel);

        // Create text fields
        JTextField aField = new JTextField();
        aField.setBounds(120, 20, 150, 25);
        frame.add(aField);

        JTextField bField = new JTextField();
        bField.setBounds(120, 60, 150, 25);
        frame.add(bField);

        JTextField resultField = new JTextField();
        resultField.setBounds(120, 100, 150, 25);
        resultField.setEditable(false); // Make result field read-only
        frame.add(resultField);

        // Create button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(20, 130, 250, 25);
        frame.add(calculateButton);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input values
                    double a = Double.parseDouble(aField.getText());
                    double b = Double.parseDouble(bField.getText());

                    // Check if a is zero
                    if (a == 0) {
                        if (b == 0) {
                            resultField.setText("Infinitely many solutions");
                        } else {
                            resultField.setText("No solution");
                        }
                    } else {
                        // Calculate the solution
                        double x = -b / a;
                        // Display result
                        resultField.setText(String.format("%.2f", x));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}