import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeeklyWeatherForecast {
    private static JSONArray periods;
    public static void main(String[] args) {
        // Get user input for latitude and longitude
        String latitude = JOptionPane.showInputDialog("Enter latitude:");
        String longitude = JOptionPane.showInputDialog("Enter longitude:");

        updatePeriods(latitude, longitude);
        // Step 1: Get the base weather API URL
        WeatherData[] allPointsForNextFiveDays = new WeatherData[120];
        for(int i = 0; i < allPointsForNextFiveDays.length; i++) {
            allPointsForNextFiveDays[i] = getOneDataPoint(i, latitude, longitude);
        }

        double totalTemp = 0;
        double totalPrecipitation = 0;
        double totalWindSpeed = 0;

        for (WeatherData weatherData : allPointsForNextFiveDays) {
            totalTemp += weatherData.getTemperature();
            totalPrecipitation += weatherData.getPrecipitation();
            totalWindSpeed += weatherData.getWindSpeed(); 
        }
        System.out.println("Data for the next 5 days: \nPrecipiatation " + totalPrecipitation/168 + "\nTemperature "+totalTemp/168 + "\nWindSpeed " + totalWindSpeed/168 );
    }

    public static void updatePeriods(String latitude, String longitude) {
        try {
            String apiUrl = "https://api.weather.gov/points/" + latitude + "," + longitude;
            JSONObject baseResponse = getJsonFromUrl(apiUrl);

            // Step 2: Extract the "forecastHourly" URL
            String hourlyUrl = (String) ((JSONObject) baseResponse.get("properties")).get("forecastHourly");

            // Step 3: Fetch and parse the hourly forecast
            JSONObject hourlyResponse = getJsonFromUrl(hourlyUrl);
            periods = (JSONArray) ((JSONObject) hourlyResponse.get("properties")).get("periods");
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.toString());
            return;
        }
        
    }

    public static WeatherData getOneDataPoint(int hourOffset, String latitude, String longitude) {
        try {
            // Step 1: Get the base weather API URL
            
            double totalTemperature = 0;
            double totalPrecipitation = 0;
            double totalWindSpeed = 0;

            
            JSONObject forecast = (JSONObject) periods.get(hourOffset);
            
            // Temperature
            double temperature = ((Number) forecast.get("temperature")).doubleValue();
            totalTemperature += temperature;

            // Probability of Precipitation
            Object precipObj = forecast.get("probabilityOfPrecipitation");
            double probabilityOfPrecipitation = precipObj == null ? 0
                    : ((Number) ((JSONObject) precipObj).get("value")).doubleValue();
            totalPrecipitation += probabilityOfPrecipitation;

            // Wind Speed (convert from string to double)
            String windSpeedStr = (String) forecast.get("windSpeed");
            double windSpeed = parseWindSpeed(windSpeedStr);
            totalWindSpeed += windSpeed;
        
            return new WeatherData(totalPrecipitation, totalTemperature, totalWindSpeed);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.toString());
            return null;
        }
    }


    // Helper method to fetch and parse JSON from a URL
    private static JSONObject getJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        

        // Read response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parse JSON
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response.toString());
    }

    // Helper method to parse wind speed string into a double
    private static double parseWindSpeed(String windSpeedStr) {
        try {
            // Extract the numeric part of the wind speed string (e.g., "15 mph")
            return Double.parseDouble(windSpeedStr.split(" ")[0]);
        } catch (Exception e) {
            return 0; // Default to 0 if parsing fails
        }
    }
}
