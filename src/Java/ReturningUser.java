public class ReturningUser extends User {
    private String password;
    private WeatherData[] history; // This should probably be an array, but we need to discuss a bit more (after exam, probably).

    public ReturningUser(String name) {
        super(name);
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WeatherData[] getHistory() {
        return this.history;
    }

    public void setHistory(WeatherData[] history) {
        this.history = history;
    }
}
