import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class MainApp extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;
    JButton LoginBtn, RegisterBtn, ExitBtn;


    public MainApp() {
        setTitle("Car Rental Management System"); 
        init();


        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public MainApp(String username, String role){
        setTitle("Car Rental Management System"); 
        init();
        System.out.println("Welcome " + username + " Role: " + role);
        JOptionPane.showMessageDialog(null, "ยิน " + username + " ");
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


        ExitBtn = new JButton("ออกจากระบบ");
        ExitBtn.setFont(font);
        ExitBtn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(ExitBtn, gbc);

       

    }


    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == ExitBtn) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
   
    }

    public static void main(String[] args) {
        new MainApp();
    }

    
}


