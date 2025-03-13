package sprint2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LargestNumberFinderGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Find the Largest of Two Numbers");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create labels
        JLabel number1Label = new JLabel("Number 1:");
        number1Label.setBounds(20, 20, 100, 25);
        frame.add(number1Label);

        JLabel number2Label = new JLabel("Number 2:");
        number2Label.setBounds(20, 60, 100, 25);
        frame.add(number2Label);

        JLabel resultLabel = new JLabel("Largest Number:");
        resultLabel.setBounds(20, 100, 120, 25);
        frame.add(resultLabel);

        // Create text fields
        JTextField number1Field = new JTextField();
        number1Field.setBounds(140, 20, 120, 25);
        frame.add(number1Field);

        JTextField number2Field = new JTextField();
        number2Field.setBounds(140, 60, 120, 25);
        frame.add(number2Field);

        JTextField resultField = new JTextField();
        resultField.setBounds(140, 100, 120, 25);
        resultField.setEditable(false); // Make result field read-only
        frame.add(resultField);

        // Create button
        JButton findLargestButton = new JButton("Find Largest");
        findLargestButton.setBounds(20, 130, 240, 25);
        frame.add(findLargestButton);

        // Add action listener to the button
        findLargestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get input values
                    double number1 = Double.parseDouble(number1Field.getText());
                    double number2 = Double.parseDouble(number2Field.getText());

                    // Find the largest number
                    double largest = Math.max(number1, number2);

                    // Display result
                    resultField.setText(String.valueOf(largest));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}