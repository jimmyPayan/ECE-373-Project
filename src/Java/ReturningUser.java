public class ReturningUser extends User {
    private String password;
    private WeatherInfo history; // This should probably be an array, but we need to discuss a bit more (after exam, probably).

    public returningUser(String name) {
        super(name);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WeatherInfo getHistory() {
        return this.history;
    }

    public void setHistory(WeatherInfo history) {
        this.history = history;
    }
}