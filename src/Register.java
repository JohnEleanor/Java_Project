import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class Register extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel, passConfirmLabel;
    JTextField userField, passField, passConfirmField;
    JButton BackToHomePage, RegisterBtn;
    public Register() {
        setTitle("Car Parking Management System"); 
        init();
        setSize(500, 250);
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
        gbc.insets=new Insets(5,5,3,5);

        Font font = new Font("Tahoma", Font.PLAIN, 15);

        userLabel = new JLabel("ชื่อผู้ใช้");
        userLabel.setFont(font);
        gbc.gridx=0;
        gbc.gridy=0;
        container.add(userLabel,gbc);

        userField = new JTextField(15);
        userField.setFont(font);
        gbc.gridx=1;
        gbc.gridy=0;
        container.add(userField,gbc);


        passLabel = new JLabel("รหัสผ่าน");
        passLabel.setFont(font);
        gbc.gridx=0;
        gbc.gridy=1;
        container.add(passLabel,gbc);

        passField = new JTextField(15);
        passField.setFont(font);
        gbc.gridx=1;
        gbc.gridy=1; 
        container.add(passField,gbc);

        passConfirmLabel = new JLabel("ยืนยันรหัสผ่าน");
        passConfirmLabel.setFont(font);
        gbc.gridx=0;
        gbc.gridy=2;
        container.add(passConfirmLabel,gbc);

        passConfirmField = new JTextField(15);
        passConfirmField.setFont(font);
        gbc.gridx=1;
        gbc.gridy=2; 
        container.add(passConfirmField,gbc);

        BackToHomePage = new JButton("กลับไปหน้าหลัก");
        BackToHomePage.setFont(font);
        BackToHomePage.addActionListener(this);
        gbc.gridx=0;
        gbc.gridy=3; 
        container.add(BackToHomePage,gbc);

        RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(font);
        RegisterBtn.addActionListener(this);
        gbc.gridx=1;
        gbc.gridy=3;
        container.add(RegisterBtn,gbc);

    }

    public void print(String text){
        System.out.println(text);
    }

    public void actionPerformed(ActionEvent event) {


        if (event.getSource() == BackToHomePage){

            print("Back to Home Page");
            
        } else if (event.getSource() == RegisterBtn){

            if (userField.getText() == "" || passField.getText() == "" || passConfirmField.getText() == "") {
                print("Data is Empty");
            } else {

                if ( passField.getText() == passConfirmField.getText() ) {
                    print("Register Success");
                } else {
                    
                    print(passField.getText());
                    print(passConfirmField.getText());
                    print("Password not match");
    
                }

            }

           
        }
    }

    public static void main(String[] args) {
        new Register();
    }

    
}


