package timsonhonhat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bai5 extends JFrame {
    private JTextField txtA, txtB, txtResult;
   private JButton btnFind, btnReset;

    public Bai4() {
        setTitle("Tìm số nhỏ nhất");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Tạo các thành phần giao diện
        JLabel lblA = new JLabel("Nhập số A:");
        txtA = new JTextField();

        JLabel lblB = new JLabel("Nhập số B:");
        txtB = new JTextField();

        JLabel lblResult = new JLabel("Số nhỏ nhất:");
        txtResult = new JTextField();
        txtResult.setEditable(false);

        btnFind = new JButton("Tìm số nhỏ nhất");
        btnReset = new JButton("Reset");

        // Xử lý sự kiện khi nhấn nút "Tìm số nhỏ nhất"
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText().trim());
                    double b = Double.parseDouble(txtB.getText().trim());

                    double min = Math.min(a, b);
                    txtResult.setText(String.valueOf(min));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Xử lý sự kiện khi nhấn nút "Reset"
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtA.setText("");
                txtB.setText("");
                txtResult.setText("");
            }
        });

        // Thêm các thành phần vào giao diện
        add(lblA); add(txtA);
        add(lblB); add(txtB);
        add(lblResult); add(txtResult);
        add(btnFind); add(btnReset);

        setVisible(true);
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai5());
    }
}
