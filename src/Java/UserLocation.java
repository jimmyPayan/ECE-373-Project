import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to manage user location retrieval
class UserLocation {
    private String location;
    
    public UserLocation() {
        // Attempt to pull location automatically (simulated)
        boolean isLocationRetrieved = pullDeviceLocation();

        // If location could not be retrieved, show GUI for manual entry
        if (!isLocationRetrieved) {
            new UserLocationGUI(this);
        }
    }

    // Simulated method to pull device location
    private boolean pullDeviceLocation() {
        // Simulating a failure to pull location from device (e.g., no permission or feature unavailable)
        System.out.println("Failed to retrieve location automatically.");
        return false; // Simulate that the location cannot be retrieved automatically
    }

    // Method to set location manually from the GUI
    public void setLocation(String location) {
        this.location = location;
        System.out.println("User's location is: " + location);
    }

    // Method to get the current location
    public String getLocation() {
        return this.location;
    }

    public static void main(String[] args) {
        new UserLocation(); // Start the application and try to retrieve the location
    }
}

// UserLocationGUI to prompt for manual location entry if automatic retrieval fails
class UserLocationGUI {
    private JFrame frame;
    private JButton allowLocationButton;
    private JButton enterLocationButton;
    private UserLocation userLocation;

    public UserLocationGUI(UserLocation userLocation) {
        this.userLocation = userLocation; // Link to the UserLocation instance

        // Create the main frame
        frame = new JFrame("User Location");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create buttons for user actions
        allowLocationButton = new JButton("Allow this device to access your location?");
        enterLocationButton = new JButton("Enter your location");

        // Add action listener for the allow location button (simulated permission grant)
        allowLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate location access granted, set a mock location
                userLocation.setLocation("Device Location: 37.7749° N, 122.4194° W"); // Example coordinates for San Francisco
                JOptionPane.showMessageDialog(frame, "Location access granted!");
                frame.dispose(); // Close the GUI
            }
        });

        // Add action listener for the enter location button (manual entry)
        enterLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt for location input
                String location = JOptionPane.showInputDialog(frame, "Enter your location:");
                if (location != null && !location.isEmpty()) {
                    userLocation.setLocation("Manual Location: " + location); // Pass the manual location back to the UserLocation object
                    frame.dispose(); // Close the GUI
                } else {
                    JOptionPane.showMessageDialog(frame, "No location entered. Please try again.");
                }
            }
        });

        // Add buttons to the frame
        frame.add(allowLocationButton);
        frame.add(enterLocationButton);
        
        // Set frame visible
        frame.setVisible(true);
    }
}
