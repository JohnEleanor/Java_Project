import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public final class Register extends JFrame implements ActionListener {
    Container container;
    JLabel userLabel, passLabel, passConfirmLabel, emailLabel;
    JTextField userField, passField, passConfirmField, emailField;
    JButton BackToHomePage, RegisterBtn;

    String url = "jdbc:mysql://localhost:3306/cafe";
    String databaseName = "cafe";
    String user = "root";
    String password = "";

    public Register() {
        setTitle("Cafe Management System");
        boolean Connect = ConnectSql();
        if (!Connect) {
            JOptionPane.showMessageDialog(null, "Can't Connect to Database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Database Connected :) ");
        }
        init();
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
     * Use Pin for Login มั้ย
     * ใช้อะไร Login
     */
    public void init() {
        container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 3, 5);

        Font font = new Font("Tahoma", Font.PLAIN, 15);

        userLabel = new JLabel("ชื่อผู้ใช้");
        userLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(userLabel, gbc);

        userField = new JTextField(15);
        userField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(userField, gbc);

        passLabel = new JLabel("รหัสผ่าน");
        passLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(passLabel, gbc);

        passField = new JTextField(15);
        passField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        container.add(passField, gbc);

        passConfirmLabel = new JLabel("ยืนยันรหัสผ่าน");
        passConfirmLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 2;
        container.add(passConfirmLabel, gbc);

        passConfirmField = new JTextField(15);
        passConfirmField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 2;
        container.add(passConfirmField, gbc);

        emailLabel = new JLabel("อีเมล์");
        emailLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 3;
        container.add(emailLabel, gbc);

        emailField = new JTextField(15);
        emailField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 3;
        container.add(emailField, gbc);

        BackToHomePage = new JButton("กลับไปหน้าหลัก");
        BackToHomePage.setFont(font);
        BackToHomePage.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        container.add(BackToHomePage, gbc);

        RegisterBtn = new JButton("สมัครสมาชิก");
        RegisterBtn.setFont(font);
        RegisterBtn.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 4;
        container.add(RegisterBtn, gbc);

    }

    public boolean ConnectSql() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SHOW DATABASES")) {
            while (rs.next()) {
                if (rs.getString(1).equals(databaseName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;

    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == BackToHomePage) {

            Login login = new Login();
            login.setVisible(true);
            this.dispose();

        } else if (event.getSource() == RegisterBtn) {

            // Check password match And not empty
            if ((passField.getText().equals(passConfirmField.getText()))
                    && (passField.getText().length() > 0 && passConfirmField.getText().length() > 0)) {

                if (userField.getText().length() > 0 && emailField.getText().length() > 0) {

                    JOptionPane.showMessageDialog(null, "Register Success", "Success", 3);
                    Login login = new Login();
                    login.setVisible(true);
                    this.dispose();

                    // ! Register Success Let Save Data to Database
                    /*
                     * username
                     * password
                     * role
                     * email
                     */

                    try (Connection conn = DriverManager.getConnection(url, user, password);
                            Statement stmt = conn.createStatement()) {
                        String sql = "INSERT INTO user (username, password, role, email) VALUES ('" + userField.getText()
                                + "', '" + passField.getText() + "', 'user', '" + emailField.getText() + "')";
                        stmt.executeUpdate(sql);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "Data Insert Error");
                    }


                } else {

                    JOptionPane.showMessageDialog(null, "Please fill all field", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {

                JOptionPane.showMessageDialog(null, "Your password not match", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }
    }

    public static void main(String[] args) {
        new Register();
    }

}
