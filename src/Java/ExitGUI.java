import javax.swing.*;
import java.awt.*;

public class ExitGUI extends GUI {
    public ExitGUI() {
        super(null, null, null);

        // Initialize components
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton("Exit");
        buttons[1] = new JButton("Return to Main Menu");
        JLabel[] labels = new JLabel[2];
        labels[0] = new JLabel("Click below to Exit");
        labels[1] = new JLabel("Click below to return to Main Menu");

        // Set button and label styles
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setBackground(new Color(220, 53, 69)); // Light red for Exit
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
        }

        buttons[1].setBackground(new Color(40, 167, 69)); // Green for Main Menu

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }

        // Set panel and class fields
        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;

        // Panel settings
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
    }

    @Override
    public void placeOnPanel() {
        panel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to panel
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i * 2;
            panel.add(labels[i], gbc);

            gbc.gridy = i * 2 + 1;
            panel.add(buttons[i], gbc);
        }

        // Button actions
        buttons[0].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Program will now exit.", "Exiting", JOptionPane.INFORMATION_MESSAGE);
            Exit.toExit();
        });

        buttons[1].addActionListener(e -> {
            //JOptionPane.showMessageDialog(panel, "Returning to Main Menu.", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            Exit.toMainMenu();
        });
    }
}
