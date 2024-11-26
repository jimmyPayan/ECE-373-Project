import javax.swing.*;
import java.awt.*;

public class ColorSettingsGUI extends GUI {
    public ColorSettingsGUI() {
        super(null, null, null);

        // Create all buttons and labels
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton("Save");
        buttons[1] = new JButton("Cancel");

        JLabel[] labels = new JLabel[1];
        labels[0] = new JLabel("Choose Color:");

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }

    public void placeOnPanel() {
        // Clear current panel and set layout options
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create color picker ComboBox
        String[] colorOptions = {"Default", "Red", "Green", "Blue"};
        JComboBox<String> colorPicker = new JComboBox<>(colorOptions);
        colorPicker.setSelectedItem(ColorSettings.selectedColor);
        colorPicker.setMaximumSize(new Dimension(150, 30));

        // Add components to the panel
        panel.add(labels[0]);
        panel.add(colorPicker);
        panel.add(buttons[0]);
        panel.add(buttons[1]);

        // Action listeners for buttons
        buttons[0].addActionListener(e -> {
            String selectedColor = (String) colorPicker.getSelectedItem();
            ColorSettings.saveColor(selectedColor);
            if (selectedColor ==  "Blue"){
                GUI.panel_color = new Color(139,133,255);
                }
            else if (selectedColor == "Red")
                GUI.panel_color = new Color(255, 137, 133);
            else if (selectedColor == "Green")
                GUI.panel_color = new Color(133,255,145);
            System.out.println("Color settings saved: " + selectedColor);
            frame.remove(panel);
            ColorSettings.toUserSettings();
        });

        buttons[1].addActionListener(e -> {
            System.out.println("Cancel and return");
            frame.remove(panel);
            ColorSettings.toUserSettings();
        });
    }

    // Main method for testing
    public static void main(String[] args) {
        ColorSettingsGUI gui = new ColorSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }
}