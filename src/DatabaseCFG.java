import java.sql.*;


public class DatabaseCFG {

    private String url = "jdbc:mysql://localhost:3306/cafe";
    private String user = "root";
    private String password = "";
    private String databaseName = "cafe";

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
    public boolean checkUser(String username, String password) {
        
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'" )) {
                if (rs.next()) {
                    System.out.println("[DatabaseCFG]: User Found");
                    return true;
                } else {
                    System.out.println("[DatabaseCFG]: User Not Found");
                    return false;
                }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }   
        return false;
    }

    public void insertUser() {

    }

    public void updateUser() {

    }

    public void deleteUser() {

    }
}
