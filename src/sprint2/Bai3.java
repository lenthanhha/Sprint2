package kiemtra_sodoixung;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bai3 extends JFrame {
    private JTextField txtNumber, txtResult;
    private JButton btnCheck, btnReset;

    public Bai3() {
        setTitle("Kiểm tra số đối xứng");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Tạo các thành phần giao diện
        JLabel lblNumber = new JLabel("Nhập số:");
        txtNumber = new JTextField();

        JLabel lblResult = new JLabel("Kết quả:");
        txtResult = new JTextField();
        txtResult.setEditable(false);

        btnCheck = new JButton("Kiểm tra");
        btnReset = new JButton("Reset");

        // Xử lý sự kiện khi nhấn nút "Kiểm tra"
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = txtNumber.getText().trim();
                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!input.matches("-?\\d+")) {
                        JOptionPane.showMessageDialog(null, "Chỉ nhập số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (isPalindrome(input)) {
                        txtResult.setText("Số đối xứng");
                    } else {
                        txtResult.setText("Không phải số đối xứng");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi không xác định!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Xử lý sự kiện khi nhấn nút "Reset"
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNumber.setText("");
                txtResult.setText("");
            }
        });

        // Thêm các thành phần vào giao diện
        add(lblNumber);
        add(txtNumber);
        add(lblResult);
        add(txtResult);
        add(btnCheck);
        add(btnReset);

        setVisible(true);
    }

    // Hàm kiểm tra số đối xứng
    private boolean isPalindrome(String num) {
        StringBuilder reversed = new StringBuilder(num).reverse();
        return num.equals(reversed.toString());
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3());
    }
}
