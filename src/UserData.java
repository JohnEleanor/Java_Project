import java.sql.*;

public class UserData {
    private String username = "";
    private String password = "";
    private String role = "";

    boolean Debug = false;

    public UserData() {
        if (Debug) System.out.println("[Debug] UserData Constructor");
    }

    public UserData(String username,String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public void setUser(String username) {

        if (username == null) {
            System.out.println("[Debug] setUser : parameter is null");
        } else {
            this.username = username;
            if(Debug) System.out.println("[Debug] setUser Successfully : " + this.username);
        }

    }

    public void setRole(String role) {
      
        if (role == null) {
            System.out.println("[Debug] setUser : parameter is null");
        } else {
            this.role = role;
            if (Debug) System.out.println("[Debug] setUser Successfully : " + this.role);
        }
    }

    public void setPassword(String password){
        
        if (password == null) {
            System.out.println("[Debug] setPassword : parameter is null");
        }else{
            if (Debug) System.out.println("[Debug] setPassword Successfully : " + password);
            this.password = password;
        }
    }

    public String getPassword() {
        return this.password;
    }


    public String getRole() {
        if (this.role == null) {
            
            DatabaseCFG db = new DatabaseCFG();
            try {
                db.Connection();
                ResultSet rs = db.getStatement().executeQuery("SELECT * FROM user WHERE username = '" + this.username + "'");
                while (rs.next()) {
                    this.role = rs.getString("role");

                    System.out.println("[Debug] getRole : " + rs.getString("role"));

                    db.closeConnection();
                    rs.close();

                    return (this.role);
                }
            } catch (Exception e) {

            }
            if (Debug) System.out.println("[Debug] getRole : role is null");

        } else {
            if (Debug) System.out.println("[Debug] role is Not Nill : " + role);
            return (this.role);
        }

        return (this.role);
    }

    public String getUsername() {
        if (this.username == null) {
            System.out.println("[Debug] getUsername : null");
            String query = "SELECT * FROM user WHERE username = '" + this.username + "'";
            System.out.println("[Debug] getUsername : null");
            DatabaseCFG db = new DatabaseCFG();
            try {
                db.Connection();
                ResultSet rs = db.getStatement().executeQuery(query);
                this.username = rs.getString("username");
                return (this.username);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            if (Debug) System.out.println("[Debug] getUsername : " + username);
            return (this.username);
        }
        return (this.role);
    }
}
