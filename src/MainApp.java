import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class MainApp extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;
    JButton LoginBtn, RegisterBtn;

    public MainApp() {
        setTitle("Car Parking Management System");
        init();


    }

    /*
     * USE Pin for Login มั้ย
     * ใช้อะไร Login
     */
    public void init() {
        container = getContentPane();
        container.setLayout(new FlowLayout());

        Font font = new Font("Tahoma", Font.PLAIN, 15);
        JFrame f = new JFrame("Login Form");

        // Create components
        JLabel userJLabel = new JLabel("ชื่อผู้ใช้ :");
        userJLabel.setFont(font);
        JLabel pass = new JLabel("รหัสผ่าน :");
        pass.setFont(font);

        JTextField userField = new JTextField(10);
        JPasswordField passf = new JPasswordField(10);

        JButton Loginbtn = new JButton("เข้าสู่ระบบ");
        Loginbtn.setFont(font);
        JButton RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(font);

        // Set layout manager
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 5);

        // Add username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(userJLabel, gbc);

        // Add username field
        gbc.gridx = 1;
        f.add(userField, gbc);

        // Add password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        f.add(pass, gbc);

        // Add password field
        gbc.gridx = 1;
        f.add(passf, gbc);

        // Add login button
        gbc.gridx = 1;
        gbc.gridy = 2;
        f.add(Loginbtn, gbc);

        // Add Register button
        gbc.gridx = 2;
        gbc.gridy = 2;
        f.add(RegisterBtn, gbc);

        f.setBounds(500, 200, 400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
        Container c = f.getContentPane();
        System.out.println(c);

       

    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == LoginBtn) {
            System.out.println("Login button clicked");
        } else if (event.getSource() == RegisterBtn) {
            System.out.println("Register button clicked");
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

}
