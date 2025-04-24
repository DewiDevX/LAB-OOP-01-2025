package login_app.models;

public class User {
    private String username;
    private String password;
    private boolean isBlocked = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean isBlocked() {
        return isBlocked;
    }
    
    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
