import javax.swing.JOptionPane;

public class UserData {
    private String username = "";
    private String role;

    public void SetDataUser(String username, String role) {
        this.username = username;
        this.role = role;


        System.out.println("[UserData] Welcome " + this.username + " Role: " + this.role);
        JOptionPane.showMessageDialog(null, "Welcome " + this.username + "", "Alert", 3);
    }
}
