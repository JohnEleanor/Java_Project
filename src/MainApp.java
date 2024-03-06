import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class MainApp extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;
    JButton LoginBtn, RegisterBtn;
    public MainApp() {
        setTitle("Bank Account Management System"); 
        init();
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    /*
     * USE Pin for Login มั้ย
     * ใช้อะไร Login 
     */
    public void init() {
        container = getContentPane();
        container.setLayout(new FlowLayout());

        // Set font globally
        Font font = new Font("Tahoma", Font.PLAIN, 15);

        userLabel = new JLabel("ชื่อผู้ใช้");
        userLabel.setFont(font);
        container.add(userLabel);

        userField = new JTextField(15);
        userField.setFont(font);
        container.add(userField);

        container.add(Box.createHorizontalStrut(500));

        passLabel = new JLabel("รหัสผ่าน");
        passLabel.setFont(font);
        container.add(passLabel);

        passField = new JTextField(15);
        passField.setFont(font);
        container.add(passField);

        LoginBtn = new JButton("เข้าสู่ระบบ");
        LoginBtn.setFont(font);
        LoginBtn.addActionListener(this);
        container.add(LoginBtn);

        RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(font);
        RegisterBtn.addActionListener(this);
        container.add(RegisterBtn);
    }

    public void actionPerformed(ActionEvent event) {


        if (event.getSource() == LoginBtn){
            System.out.println("Login button clicked");
        } else if (event.getSource() == RegisterBtn){
            System.out.println("Register button clicked");
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

    
}


