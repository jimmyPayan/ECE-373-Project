import javax.swing.*;

import java.awt.*;

public class ColorSettingsGUI extends GUI {
    public ColorSettingsGUI() {
        super(null, null, null);

        // Create all buttons and labels
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[2];
        buttons[0] = new ColorButton("");
        buttons[1] = new ColorButton("");

        ImageIcon[] icons = new ImageIcon[buttons.length];
        icons[0] = new ImageIcon("../media/save-regular.png");
        icons[1] = new ImageIcon("../media/arrow-left-solid.png");
        for (int i = 0; i < buttons.length; i++) {
            ImageIcon icon = icons[i];
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            buttons[i].setIcon(new ImageIcon(img));
            buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
        }  

        JLabel[] labels = new JLabel[3];
        labels[0] = new JLabel("Choose Color", SwingConstants.RIGHT);
        labels[1] = new JLabel("Save", SwingConstants.RIGHT);
        labels[2] = new JLabel("Back", SwingConstants.RIGHT);

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }

    public void placeOnPanel() {
        // Clear current panel and set layout options
        panel.removeAll();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally
        gbc.weightx = 1.0; // Allow buttons/labels to stretch


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the image
        try {
            // Load the image and resize it to 300x300 pixels
            ImageIcon originalIcon = new ImageIcon("../media/palette-solid.png");
            Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            
            JLabel imageLabel = new JLabel(resizedIcon);
            panel.add(imageLabel, gbc);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Image not found", SwingConstants.CENTER);
            errorLabel.setForeground(Color.RED);
            panel.add(errorLabel, gbc);
        }

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST; // Left-align subsequent components
        gbc.gridy++;

        // Create color picker ComboBox
        String[] colorOptions = {"Default", "Red", "Green", "Blue", "Pink", "Yellow", "Purp", "Orange"};
        JComboBox<String> colorPicker = new JComboBox<>(colorOptions);
        colorPicker.setSelectedItem(ColorSettings.selectedColor);
        colorPicker.setMaximumSize(new Dimension(150, 30));


        gbc.gridx = -0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(this.labels[0], gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(colorPicker, gbc);
        gbc.gridy++;

        for (int i = 0; i < buttons.length; i++) {
            gbc.gridx = 0; // First column
                gbc.fill = GridBagConstraints.HORIZONTAL;
                panel.add(this.labels[i + 1], gbc);

                // Add buttons
                gbc.gridx = 1; // Second column
                gbc.fill = GridBagConstraints.NONE;
                panel.add(this.buttons[i], gbc);

                gbc.gridy++;
        }
        // Add components to the panel


        //panel.add(labels[0]);
        //panel.add(colorPicker);
        //panel.add(buttons[0]);
        //panel.add(buttons[1]);

        // Action listeners for buttons
        buttons[0].addActionListener(e -> {
            String selectedColor = (String) colorPicker.getSelectedItem();
            ColorSettings.saveColor(selectedColor);
            if (selectedColor ==  "Blue"){
                GUI.panel_color = new Color(139,133,255);
                ColorButton.color = new Color(216, 214, 255);
                }
            else if (selectedColor == "Red"){
                GUI.panel_color = new Color(255, 137, 133);
                ColorButton.color  = new Color(255, 216, 214);
            }
            else if (selectedColor == "Green"){
                GUI.panel_color = new Color(133,255,145);
                ColorButton.color = new Color(214, 255, 218);
            }
            else if (selectedColor == "Pink"){// cause why tf not?
                GUI.panel_color = new Color(255, 158, 224);
                ColorButton.color = new Color(255, 224, 245);
            }
            else if (selectedColor == "Yellow"){// cause why tf not?
                GUI.panel_color = new Color(235, 255, 82);
                ColorButton.color = new Color(247, 255, 189);
            }
            else if (selectedColor == "Purp"){// cause why tf not?
                GUI.panel_color = new Color(192, 133, 255);
                ColorButton.color = new Color(229, 204, 255);
            }
            else if (selectedColor == "Orange"){// cause why tf not?
                GUI.panel_color = new Color(255, 181, 61);
                ColorButton.color = new Color(255, 212, 143);
            }
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