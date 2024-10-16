
public class WeatherData {
    private double precipitation; // Stores precipitation data
    private double temperature;    // Stores temperature data
    private String windSpeed;      // Stores wind speed data

    // Getters and Setters for each data field
    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
