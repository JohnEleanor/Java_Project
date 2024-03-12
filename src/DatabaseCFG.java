import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseCFG {
    private String databaseName = "car_rental_system";

    private String url = "jdbc:mysql://localhost:3306/"+this.databaseName;
    private String user = "root";
    private String password = "";
    

    public void init() {
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SHOW DATABASES")) {
            while (rs.next()) {
                if (rs.getString(1).equals(this.databaseName)) {
                    System.out.println("[DatabseCFG]: Database Found");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    /*
     * ! Zone For User
     */

    public boolean checkUser(String username, String password, boolean isLogin) {

        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'")) {
            if (conn.isClosed()) {
                System.out.println("[Debug]: Connection Closed");
            } else {
                if (rs.next()) {

                    if (isLogin) {

                        System.out.println("[Debug]: isLogin True");
                        return true;
                    } else {

                        System.out.println("[Debug]: User Found");
                        return false;
                    }

                } else {
                    System.out.println("[Debug]: User Not Found");
                    return false;
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return false;
    }

    public boolean insertUser(String username, String password, String email) {
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO user (username, password, role, email) VALUES ('" + username + "', '" + password
                    + "', 'user', '" + email + "')";
            stmt.executeUpdate(sql);

            if (checkUser(username, password, false)) {
                System.out.println("[Debug]: User Insert Successfully");
                return true;
            } else {

                System.out.println("[Debug]: User Have Already");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Insert Error");
        }
        return false;
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public String getRole(String username, String password) {
        String role = "";
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'")) {
            if (rs.next()) {
                role = rs.getString("role");
                return role;

            } else {
                System.out.println("[Debug]: User Not Found");
                return "";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return ("");
    }
}
