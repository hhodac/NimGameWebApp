public class Player {
    private String username;

    public Player() {
        username = null;
    }

    public Player(String name) {
        username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
