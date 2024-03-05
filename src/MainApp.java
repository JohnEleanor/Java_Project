import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class MainApp extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;

    public MainApp() {
        setTitle("Bank Account Management System"); 
        init();
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void init() {
        container = getContentPane();
        container.setLayout(new FlowLayout());

        userLabel = new JLabel("ชื่อผู้ใช้");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); // Set font to Thai
        container.add(userLabel);

        userField = new JTextField(15);
        container.add(userField);

        
        container.add(Box.createHorizontalStrut(500));

        passLabel = new JLabel("รหัสผ่าน");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); // Set font to Thai
        container.add(passLabel);

        passField = new JTextField(15);
        container.add(passField);

        JButton LoginBtn = new JButton("เข้าสู่ระบบ");
        LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        LoginBtn.addActionListener(this);
        container.add(LoginBtn);

        JButton RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        RegisterBtn.addActionListener(this);
        container.add(RegisterBtn);

        
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Button clicked");
    }

    public static void main(String[] args) {
        new MainApp();
    }

    
}


