

public class UserData {
    private String username;
    private String role;

    public void SetDataUser(String Input_username, String Input_role) {
        this.username = Input_username;
        this.role = Input_role;
        System.out.println("[UserData] Welcome " + Input_username + " Role: " + Input_role);
        System.out.println("[UserData] Welcome " + this.username + " Role: " + this.role);

        // JOptionPane.showMessageDialog(null, "Welcome " + this.username + "", "Alert", 3);
    }

    public String getRole(){
        System.out.println("getRole => "+this.role);
        return this.role;
    }

    public String getUsername() {
        System.out.println("getUsername => "+this.username);
        return this.username;
    }
}
