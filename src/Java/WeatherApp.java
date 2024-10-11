import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main Weather Display GUI
class WeatherDisplayGUI {
    private JFrame frame;
    private JButton settingsButton;

    public WeatherDisplayGUI() {
        // Create the main frame
        frame = new JFrame("Weather Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create button to access Weather Settings
        settingsButton = new JButton("Go to Weather Settings");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeatherSettingsGUI.showSettings(); // Call the method to show Weather Settings
                frame.dispose(); // Close the Weather Display GUI
            }
        });

        frame.add(settingsButton);
        frame.setVisible(true);
    }
}

// Weather Settings GUI
class WeatherSettingsGUI {
    private static JFrame frame; // Make frame static for easy access
    private JButton mainMenuButton;
    private JButton dateButton;
    private JButton exitButton;

    public static void showSettings() {
        frame = new JFrame("Weather Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create buttons for navigation
        WeatherSettingsGUI settingsGUI = new WeatherSettingsGUI(); // Instance for button actions

        settingsGUI.mainMenuButton = new JButton("Go to Main Menu");
        settingsGUI.dateButton = new JButton("Go to Date GUI");
        settingsGUI.exitButton = new JButton("Exit");

        // Action for Main Menu button
        settingsGUI.mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenuGUI(); // Open Main Menu GUI
                frame.dispose(); // Close the Weather Settings GUI
            }
        });

        // Action for Date GUI button
        settingsGUI.dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DateGUI(); // Open Date GUI
                frame.dispose(); // Close the Weather Settings GUI
            }
        });

        // Action for Exit button
        settingsGUI.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Add buttons to the settings frame
        frame.add(settingsGUI.mainMenuButton);
        frame.add(settingsGUI.dateButton);
        frame.add(settingsGUI.exitButton);
        frame.setVisible(true);
    }
}

// Main Menu GUI
class MainMenuGUI {
    private JFrame frame;

    public MainMenuGUI() {
        // Create the main menu frame
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Welcome to the Main Menu");
        frame.add(label);

        frame.setVisible(true);
    }
}

// Date GUI
class DateGUI {
    private JFrame frame;

    public DateGUI() {
        // Create the date frame
        frame = new JFrame("Date GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Select a Date");
        frame.add(label);

        frame.setVisible(true);
    }
}

// Main class to run the application
public class WeatherApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherDisplayGUI());
    }
}
