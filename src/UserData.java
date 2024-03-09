

public class UserData {
    private String username;
    private String role;


    public void setUser(String username) {

        if (username == null){
            System.out.println("[Debug] setUser : parameter is null");
        }else {
            this.username = username;
            System.out.println("[Debug] setUser Successfully : " + this.username);
        }
        

    }

    public void setRole(String role) {

        if (role == null){
            System.out.println("[Debug] setUser : parameter is null");
        }else {
            this.role = role;
            System.out.println("[Debug] setUser Successfully : " + this.role);
        }

    }

    public String getRole(){
        if (this.role == null){
            System.out.println("[Debug] getRole : role is null");
            
        }else {
            System.out.println("[Debug] getRole : " + role);
            return (this.role);
        }

        return ("NILL");
    }

    public String getUsername() {
        if (this.username == null){
            System.out.println("[Debug] getUsername : null");
        }  else {
            System.out.println("[Debug] getUsername : " + username);
            return (this.username);
        }
       return ("NILL");
    }
}
