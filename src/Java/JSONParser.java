import org.json.JSONObject;

public class JSONParser {
    public WeatherData parseWeatherData(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        double precipitation = jsonObject.getDouble("probabilityOfPrecipitation");
        double temperature = jsonObject.getDouble("temperature");
        String windSpeed = jsonObject.getInputStream("windSpeed");
      

        return new WeatherData(precipitation, temperature, windSpeed);
    }
}

