import javax.swing.*;
import java.awt.*;

public class MainMenuGUI extends GUI {

    public MainMenuGUI() {
        super(null, null, null);

        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[4];
        // Define buttons
        buttons[0] = new JButton("");
        buttons[1] = new JButton("");
        buttons[2] = new JButton("");
        buttons[3] = new JButton("");
        for (int i = 0; i < buttons.length; i++) {
            ImageIcon icon = new ImageIcon("button" + i + ".png"); // Replace with actual image paths
            Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            buttons[i].setIcon(new ImageIcon(img));
            buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            buttons[i].setVerticalTextPosition(SwingConstants.BOTTOM);
        }        

        JLabel[] labels = new JLabel[4];
        // Define labels with right alignment
        labels[0] = new JLabel("Proceed to Login", SwingConstants.RIGHT);
        labels[1] = new JLabel("Enter today's Date", SwingConstants.RIGHT);
        labels[2] = new JLabel("Settings", SwingConstants.RIGHT);
        labels[3] = new JLabel("Exit", SwingConstants.RIGHT);

        this.panel = panel;
        panel.setBackground(new Color(70, 130, 180)); // Steel Blue background
        this.buttons = buttons;
        this.labels = labels;
    }

    @Override
    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally
        gbc.weightx = 1.0; // Allow buttons/labels to stretch

        // Add the resized image to the top of the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the image
        try {
            // Load the image and resize it to 300x300 pixels
            ImageIcon originalIcon = new ImageIcon("mainmenu.png");
            Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            
            JLabel imageLabel = new JLabel(resizedIcon);
            panel.add(imageLabel, gbc);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Image not found", SwingConstants.CENTER);
            errorLabel.setForeground(Color.RED);
            panel.add(errorLabel, gbc);
        }

        // Reset grid width for labels and buttons
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST; // Left-align subsequent components
        gbc.gridy++;

        // Add labels and buttons
        for (int i = 0; i < labels.length; i++) {
            // Add labels (right-aligned)
            gbc.gridx = 0; // First column
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(this.labels[i], gbc);

            // Add buttons
            gbc.gridx = 1; // Second column
            gbc.fill = GridBagConstraints.NONE;
            panel.add(this.buttons[i], gbc);

            gbc.gridy++; // Move to the next row
        }

        // Listener events for each button
        buttons[0].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Navigating to LoginGUI", "Info", JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            MainMenu.toLogin();
        });
        buttons[1].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Navigating to DateGUI", "Info", JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            MainMenu.toDate();
        });
        buttons[2].addActionListener(e -> {
            frame.remove(panel);
            MainMenu.toSettings();
        });
        buttons[3].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Exiting application", "Info", JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            MainMenu.toExit();
        });
    }

    public static void main(String[] args) {
        MainMenuGUI gui = new MainMenuGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }
}
