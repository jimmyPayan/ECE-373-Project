import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to hold color settings
class ColorSettings {
    private Color bgColor;
    private Color fgColor;

    // Default colors
    public static final Color DEFAULT_BG_COLOR = Color.WHITE;
    public static final Color DEFAULT_FG_COLOR = Color.BLACK;

    public ColorSettings() {
        // Initialize colors to default
        this.bgColor = DEFAULT_BG_COLOR;
        this.fgColor = DEFAULT_FG_COLOR;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
        System.out.println("Background Color set to: " + bgColor);
    }

    public Color getFgColor() {
        return fgColor;
    }

    public void setFgColor(Color fgColor) {
        this.fgColor = fgColor;
        System.out.println("Foreground Color set to: " + fgColor);
    }
}

// Class to handle the GUI
public class ColorSettingsApp {
    private JFrame frame;
    private JDialog colorDialog;
    private JButton changeBgColorButton;
    private JButton changeFgColorButton;
    private ColorSettings colorSettings; // Reference to ColorSettings instance

    public ColorSettingsApp() {
        // Initialize ColorSettings
        colorSettings = new ColorSettings();

        // Create the main frame
        frame = new JFrame("Color Settings GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create buttons for changing colors
        changeBgColorButton = new JButton("Change Background Color");
        changeFgColorButton = new JButton("Change Foreground Color");

        // Add action listeners to buttons
        changeBgColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newBgColor = JColorChooser.showDialog(frame, "Choose Background Color", colorSettings.getBgColor());
                if (newBgColor != null) {
                    colorSettings.setBgColor(newBgColor); // Update the ColorSettings instance
                    updateDialogColors(); // Update dialog colors
                }
            }
        });

        changeFgColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newFgColor = JColorChooser.showDialog(frame, "Choose Foreground Color", colorSettings.getFgColor());
                if (newFgColor != null) {
                    colorSettings.setFgColor(newFgColor); // Update the ColorSettings instance
                    updateDialogColors(); // Update dialog colors
                }
            }
        });

        // Create a dialog box to demonstrate color changes
        createColorDialog();

        // Add buttons to the main frame
        frame.add(changeBgColorButton);
        frame.add(changeFgColorButton);

        // Set frame visible
        frame.setVisible(true);
    }

    private void createColorDialog() {
        colorDialog = new JDialog(frame, "Color Dialog", true);
        colorDialog.setSize(250, 150);
        colorDialog.setLocationRelativeTo(frame);
        colorDialog.setLayout(new FlowLayout());
        colorDialog.add(new JLabel("This is a color dialog"));
        updateDialogColors(); // Set initial colors
        colorDialog.setVisible(true);
    }

    private void updateDialogColors() {
        colorDialog.getContentPane().setBackground(colorSettings.getBgColor());
        colorDialog.setForeground(colorSettings.getFgColor());
        colorDialog.getContentPane().setForeground(colorSettings.getFgColor());
    }

    public static void main(String[] args) {
        // Create and show the ColorSettingsApp
        SwingUtilities.invokeLater(() -> new ColorSettingsApp());

        // Additional testing of ColorSettings
        ColorSettings settings = new ColorSettings();
        System.out.println("Initial Background Color: " + settings.getBgColor());
        System.out.println("Initial Foreground Color: " + settings.getFgColor());

        // Test setting new colors
        settings.setBgColor(Color.RED);
        settings.setFgColor(Color.BLUE);
        System.out.println("Updated Background Color: " + settings.getBgColor());
        System.out.println("Updated Foreground Color: " + settings.getFgColor());
    }
}
