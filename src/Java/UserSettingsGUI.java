import javax.swing.*;
import java.awt.*;

public class UserSettingsGUI extends GUI {
    
    public UserSettingsGUI() {
        super(null, null, null);
        // Create all buttons and labels
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[3];
        buttons[0] = new ColorButton("");
        buttons[1] = new ColorButton("");
        buttons[2] = new ColorButton(""); //; change locaiton

        ImageIcon[] icons = new ImageIcon[buttons.length];
        icons[0] = new ImageIcon("../media/map-marked-alt-solid.png");
        icons[1] = new ImageIcon("../media/palette-solid.png");
        icons[2] = new ImageIcon("../media/arrow-left-solid.png");
        for (int i = 0; i < buttons.length; i++) {
            ImageIcon icon = icons[i];
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            buttons[i].setIcon(new ImageIcon(img));
            buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
        }  

        JLabel[] labels = new JLabel[4];
        // define labels
        labels[0] = new JLabel("Select Degree Unit:", SwingConstants.RIGHT);
        labels[1] = new JLabel("Change Location", SwingConstants.RIGHT);
        labels[2] = new JLabel("Change Color", SwingConstants.RIGHT);
        labels[3] = new JLabel("Back", SwingConstants.RIGHT);

        //labels[2] = new JLabel("Change Location");

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }

    @Override
    public void placeOnPanel() {
        // clear current panel / set layout options
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
            ImageIcon originalIcon = new ImageIcon("../media/wrench-solid.png");
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
        
        String[] degree_list = {"F", "C"}; 
        JComboBox<String> degree_sel = new JComboBox<String>(degree_list);
        degree_sel.setSelectedItem(UserSettings.degree);
        gbc.gridx = -0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(this.labels[0], gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(degree_sel, gbc);
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
        // combobox for degree unit selection
        
        //degree_sel.setMaximumSize(new Dimension(50, 30));

        
        // add all to panel
        
        //panel.add(degree_sel);
        //panel.add(labels[1]);
        //panel.add(buttons[0]);
        //panel.add(labels[2]);
        //panel.add(buttons[2]);
        //panel.add(buttons[1]);
        this.panel.setBackground(GUI.panel_color);
        
        // action listeners for all buttons
        buttons[1].addActionListener(e -> {
            UserSettings.degree = degree_list[degree_sel.getSelectedIndex()];
            System.out.println("SettingsCall: color");
            //SwingUtilities.invokeLater(() -> new ColorSettingsApp());
            frame.remove(panel);
            UserSettings.toColor();
        });

        buttons[2].addActionListener(e -> {
            System.out.println("SettingsCall: MainMenu");
            UserSettings.degree = degree_list[degree_sel.getSelectedIndex()];
            frame.remove(panel);
            UserSettings.toMenu();
        });

        buttons[0].addActionListener(e -> {
            UserSettings.degree = degree_list[degree_sel.getSelectedIndex()];
            System.out.println("SettingsCall: location");
            String a = "░░░░░░░░░░░░░░░▄▄▄█▀▀▀▀▀▀▀▄▄▄░░░░░░░░░░\n░░░░░░░░░░░░▄█▀▀░░░░░░░░░░░▄█▀█▄▄░░░░░░\n░░░░░░░░░░▄█▀░░░░░░░░░░░░░░█░█▄░▀█▄░░░░\n░░░░░░░░░░█░░░░░░░░░░░▄░▄░░▄░▄▀░░░░█▄░░\n░░░░░░░░░█░░░░░░░░░░▄▄▄▀██▄░█▄░▄▄░░░▀▄░\n░░░░░░░░█▀░░░░░░░░░░░▀█▄░▄██░███▀█▄░░█▄\n░░░░░░░░█░░░░░░░░░░░▀▀▀▀▀░░░░▀████▀░░░█\n░░░░░░░░█░░░░░░░░░░░░░▀▀▀░▄▄▄░░█░░░░░░█\n░░░░░░░░█░░░░░░░░░░░░░░░░░██▀▀▀▀█░░░░░█\n░░░░░░░░█░░░░░░░░░░░░░░░░█░▄▀▄▄▄▀░░░░░█\n░░░░░░░░█░░░░░░░░░░░░░░░░██▀████░░░░░▄█\n░░░░░░░░█▄░░░░░░░░░░░░░░░█▄█████░░░░░█░\n░░░░░░░░░█▄░░░░░░░░░░░░░▀▀█████▀░░░░▄▀░\n░░░░░░░░░▄██▄░░░░░░░░░░▄▄▄▄▄░░▄░░░▄█▀░░\n░░░░░░░▄█▀▄░░▀▀▄▄░░▄▄▀░▀░░░░▀▀▀▄▄▀▀░░░░\n░░░░░▄█▀░░░▀▄░░░░▀▀▀██▄▄▄▄▄▄█▀▀░░░░░░░░\n░░░▄▀░░░░░░░░█▄░░░░░░░▄█▀▄░▄▄▄░░░░▀███░\n░░█▀░░░░░░░░░░▀█▄░░░░▄█▄▄▄█████▄▄▄▀░░░░\n▄▀░░░░░░░░░░░░░░░▀▀▀█▀▀▀░░░░▀██▀▀░░░░░░\n";String [] b = a.split("\n");for (String c : b){System.out.println(c);try{Thread.sleep(30);}catch (Exception z){}}
            // go to location settings ui
        });
    }

    // main for testing
    public static void main(String[] args) {
        UserSettingsGUI gui = new UserSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }


}
