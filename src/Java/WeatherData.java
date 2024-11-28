
public class WeatherData {
    private double precipitation; // Stores precipitation data
    private double temperature;    // Stores temperature data
    private double windSpeed;      // Stores wind speed data

    public WeatherData(double precipitation, double temperature, double windSpeed) {
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
