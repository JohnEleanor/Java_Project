

public class UserData {
    private String username;
    private String role;


    public UserData() {
        username = "";
        role = "";
    }


    public UserData(String Input_username, String Input_role) {
        
        this.username = Input_username;
        this.role = Input_role;

        System.out.println("[Debug] Input : " + Input_username + " Role : " + Input_role);
        System.out.println("[Debug] Set Data Already : " + username + " Role : " + role);

    }

    public void setUser(String Input_username) {

        username = Input_username;

    }

    public void setRole(String Input_role) {
        role = Input_role;

    }


    public String getRole(){
       
        return (this.role);
    }

    public String getUsername() {
        
        return (this.username);
    }
}
