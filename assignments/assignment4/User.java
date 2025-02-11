public class User {
    private String username;
    private int password;

    User(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, int password) {
        return this.username.equals(username) && this.password == password;
    }
}
