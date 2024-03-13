import java.sql.*;

public class DatabaseCFG {
    // Database Configuration
    private String databaseName = "car_rental_system";
    private String url = "jdbc:mysql://localhost:3306/"+this.databaseName;
    private String user = "root";
    private String password = "";

    Connection conn = null;
    Statement stmt = null;
    

    
    public void Connection() throws SQLClientInfoException, Exception {
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        System.out.println("[Debug]: Database Connected Successfully");
    }

    /*
     * ! Zone For User
    */

    public Statement getStatement() {
        return this.stmt;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public boolean checkUser(String username, String password) {

        try {
            DatabaseCFG db = new DatabaseCFG();
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
            while (rs.next()) {
                System.out.println("[Debug]: User Found");
                return true;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean insertUser(String username, String password, String email) {
  
        try {
            DatabaseCFG db = new DatabaseCFG();
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery("INSERT INTO user (username, password, role, email) VALUES ('" + username + "', '" + password+ "', 'user', '" + email + "')");
            while (rs.next()) {
                System.out.println("[Debug]: insertUser Success");
                return true;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
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
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'")) {
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

    public boolean getUsernameisAlready(String username, String password) {
        try (Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username = '" + username + "'")) {
            if (conn.isClosed()) {
                System.out.println("[Debug]: Connection Closed");
            } else {
                //! Login Check
               
                if (rs.next()) {
                    System.out.println("[getUsernameisAlready]: User Found");
                    return true;
                } else {
                    System.out.println("[getUsernameisAlready]: User Not Found");
                    return false;
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return false;
    }
}

