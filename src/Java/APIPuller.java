package projDEV;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;    

public class APIPuller {
    private String apiUrl;

    public APIPuller(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String pullWeatherData() throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URI(apiUrl).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}

