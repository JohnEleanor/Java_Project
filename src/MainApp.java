import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public final class MainApp extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel;
    JTextField userField, passField;
    JButton Rental_Car, Rental_History, ExitBtn;
    DatabaseCFG db = new DatabaseCFG();

    boolean Debug = false;

    public MainApp() {
        init();
    }

    public MainApp(String username, String password, String role) {
        init();

        UserData userData = new UserData(username, password, role);

        String txt = "Welcome : " + username + " To Car Rental Management System";
        JOptionPane.showMessageDialog(null, txt, "Alert", 3);

        System.out.println("[Main App] : user => "+ userData.getUsername() + " password => " + userData.getPassword()+ " role => " + userData.getRole());
    }

    public void init() {
        setTitle("Car Rental Management System");

        container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,5,0,5);
        Font font = new Font("Tahoma", Font.PLAIN, 15);

        Rental_Car = new JButton("เช่ารถ");
        Rental_Car.setFont(font);
        Rental_Car.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(Rental_Car, gbc);

        Rental_History = new JButton("ประวัติการเช่ารถ");
        Rental_History.setFont(font);
        Rental_History.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(Rental_History, gbc);

        ExitBtn = new JButton("ออกจากระบบ");
        ExitBtn.setFont(font);
        ExitBtn.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 0;
        container.add(ExitBtn, gbc);

        
        // if (userData.getRole().equals("admin")) {

        //     if (Debug) System.out.println("[Debug] Admin");

        // } else if (userData.getRole().equals("staff")) {

        //     if (Debug) System.out.println("[Debug] staff");

        // } else if (userData.getRole().equals("user")) {

           


            if (Debug) System.out.println("[Debug] user");

        // } else {

        //     if (Debug) System.out.println("[Debug] Role Not Found");
        // }

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
