import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeeklyWeatherForecast {
    public static void main(String[] args) {
        try {
            // Get user input for latitude and longitude
            String latitude = JOptionPane.showInputDialog("Enter latitude:");
            String longitude = JOptionPane.showInputDialog("Enter longitude:");

            // Step 1: Get the base weather API URL
            String apiUrl = "https://api.weather.gov/points/" + latitude + "," + longitude;
            JSONObject baseResponse = getJsonFromUrl(apiUrl);

            // Step 2: Extract the "forecastHourly" URL
            String hourlyUrl = (String) ((JSONObject) baseResponse.get("properties")).get("forecastHourly");

            // Step 3: Fetch and parse the hourly forecast
            JSONObject hourlyResponse = getJsonFromUrl(hourlyUrl);
            JSONArray periods = (JSONArray) ((JSONObject) hourlyResponse.get("properties")).get("periods");

            // Step 4: Calculate weekly averages
            int hoursToProcess = Math.min(periods.size(), 168); // Limit to 7 days (168 hours)
            double totalTemperature = 0;
            double totalPrecipitation = 0;
            double totalWindSpeed = 0;
            int validDataPoints = 0;

            for (int i = 0; i < hoursToProcess; i++) {
                JSONObject forecast = (JSONObject) periods.get(i);
                
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

                validDataPoints++;
            }

            // Compute averages
            double avgTemperature = totalTemperature / validDataPoints;
            double avgPrecipitation = totalPrecipitation / validDataPoints;
            double avgWindSpeed = totalWindSpeed / validDataPoints;

            // Step 5: Display the results
            String result = String.format(
                "Weekly Averages:\nTemperature: %.1f°F\nProbability of Precipitation: %.1f%%\nWind Speed: %.1f mph",
                avgTemperature, avgPrecipitation, avgWindSpeed);
            JOptionPane.showMessageDialog(null, result);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
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
