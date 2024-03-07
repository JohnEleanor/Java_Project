import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class Login extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;
    JButton LoginBtn, RegisterBtn;
    public Login() {
        setTitle("Cafe Management System"); 
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
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(5,5,5,5);

        Font font = new Font("Tahoma", Font.PLAIN, 15);

        userLabel = new JLabel("ชื่อผู้ใช้");
        userLabel.setFont(font);
        gbc.gridx=0;
        gbc.gridy=0;
        container.add(userLabel,gbc);

        userField = new JTextField(10);
        userField.setFont(font);
        gbc.gridx=1;
        gbc.gridy=0;
        container.add(userField,gbc);


        passLabel = new JLabel("รหัสผ่าน");
        passLabel.setFont(font);
        gbc.gridx=0;
        gbc.gridy=1;
        container.add(passLabel,gbc);

        passField = new JTextField(10);
        passField.setFont(font);
        gbc.gridx=1;
        gbc.gridy=1; 
        container.add(passField,gbc);

        RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(font);
        RegisterBtn.addActionListener(this);
        gbc.gridx=0;
        gbc.gridy=3;
        container.add(RegisterBtn,gbc);

        LoginBtn = new JButton("เข้าสู่ระบบ");
        LoginBtn.setFont(font);
        LoginBtn.addActionListener(this);
        gbc.gridx=1;
        gbc.gridy=3; 
        container.add(LoginBtn,gbc);

      

    }


    public void actionPerformed(ActionEvent event) {


        if (event.getSource() == LoginBtn){

            System.out.println("This is Username : "+userField.getText());
            System.out.println("This is Password : "+passField.getText());

            System.out.println("=====================================");
        } else if (event.getSource() == RegisterBtn){


            Register register = new Register();
            register.setVisible(true);
            this.dispose();

        }
    }

    public static void main(String[] args) {
        new Login();
    }

    
}


