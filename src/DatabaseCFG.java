import java.sql.*;

public class DatabaseCFG {
    // Database Configuration
    private String databaseName = "car_rental_system";
    private String url = "jdbc:mysql://localhost:3306/" + this.databaseName;
    private String user = "root";
    private String password = "";

    Connection conn = null;
    Statement stmt = null;

    boolean Debug = false;

    public void Connection() throws SQLClientInfoException, Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        if (Debug) System.out.println("[Debug]: Database Connected Successfully");
    }

    public Statement getStatement() {
        return this.stmt;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() {
        try {
            conn.close();
            stmt.close();
            if (Debug) System.out.println("[Debug]: Database Connection Closed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkUser(String username, String password) {

        try {
            DatabaseCFG db = new DatabaseCFG();
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery("SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
            while (rs.next()) {
                if (Debug) System.out.println("[Debug]: User Found");
                db.closeConnection();
                rs.close();
                return true;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean insertUser(String username, String password, String email) {
        String query = "INSERT INTO user (username, password, role, email) VALUES ('"+ username + "', '" + password + "', 'user', '" + email + "')";
        try {
            DatabaseCFG db = new DatabaseCFG();
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery(query);
            while (rs.next()) {
                if (Debug) System.out.println("[Debug]: insertUser Success");
                db.closeConnection();
                rs.close();
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
        System.out.println("[DatabaseCFG] getRole =>  Username: " + username + " Password: " + password);
        DatabaseCFG db = new DatabaseCFG();
        // UserData userData = new UserData();
        String role ="NOT FOUND";
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery(query);
            while (rs.next()) {
                role = rs.getString("role");

                // userData.setRole(role);
                // userData.setUser(username);
                // Close Connection
                db.closeConnection();
                rs.close();
                return role;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return role;
    }

    public boolean getUsernameisAlready(String username, String password) {
        DatabaseCFG db = new DatabaseCFG();
        String query = "SELECT * FROM user WHERE username = '" + username + "'";
        try {
            db.Connection();
            ResultSet rs = db.getStatement().executeQuery(query);
            while (rs.next()) {
                if (Debug) System.out.println("[Debug]: User Found");
                return true;
            }
            db.closeConnection();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
