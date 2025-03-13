
package sprint2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai5 extends JFrame implements ActionListener {
    private JTextField textField1, textField2, resultField;
    private JButton calculateButton, clearButton;

    public Bai5() {
        setTitle("Tính USCLN");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Ô nhập số thứ nhất
        add(new JLabel("Nhập số thứ nhất:"));
        textField1 = new JTextField();
        add(textField1);

        // Ô nhập số thứ hai
        add(new JLabel("Nhập số thứ hai:"));
        textField2 = new JTextField();
        add(textField2);

        // Nút tính toán
        calculateButton = new JButton("Tính USCLN");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Nút xóa
        clearButton = new JButton("Xóa");
        clearButton.addActionListener(this);
        add(clearButton);

        // Ô hiển thị kết quả
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    // Hàm tính USCLN bằng thuật toán Euclid
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());

            if (e.getSource() == calculateButton) {
                int gcd = findGCD(num1, num2);
                resultField.setText("USCLN: " + gcd);
            } else if (e.getSource() == clearButton) {
                textField1.setText("");
                textField2.setText("");
                resultField.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new Bai5();
    }
}