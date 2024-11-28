import javax.swing.*;

public class WeatherDisplayGUITest {
    public static void main(String[] args) {
        // Sample WeatherData array
        WeatherData[] sampleData = new WeatherData[5];
        sampleData[0] = new WeatherData(10.5, 22.3, 15.8);
        sampleData[1] = new WeatherData(20.2, 24.1, 10.5);
        sampleData[2] = new WeatherData(5.0, 19.8, 8.3);
        sampleData[3] = new WeatherData(12.0, 23.5, 12.7);
        sampleData[4] = new WeatherData(8.0, 25.2, 9.1);

        // Create a JFrame for testing
        JFrame testFrame = new JFrame("Weather Display Test");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setSize(600, 400); // Width and height of the frame

        // Create WeatherDisplayGUI and add it to the frame
        WeatherDisplayGUI weatherGUI = new WeatherDisplayGUI(sampleData);
        weatherGUI.placeOnPanel(); // Set up the panel inside the GUI
        testFrame.add(weatherGUI.panel); // Add the GUI panel to the frame

        // Display the frame
        testFrame.setVisible(true);
    }
}
