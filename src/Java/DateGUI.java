import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateGUI extends GUI {
    public DateGUI() {
        super(null, null, null);

        // Set up the main panel
        JPanel panel = new JPanel(new GridBagLayout());
        this.panel = panel;

        // Define buttons
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton("Submit");
        buttons[1] = new JButton("Back");
        this.buttons = buttons;

        // Define labels
        JLabel[] labels = new JLabel[2];
        labels[0] = new JLabel("Forecast days from now:");
        labels[1] = new JLabel("Current Time (24hr, HH:MM):");

        // Set label styles
        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        for (JLabel label : labels) {
            label.setFont(labelFont);
            label.setHorizontalAlignment(SwingConstants.LEFT); // Align labels to the left
        }
        this.labels = labels;
    }

    public void placeOnPanel() {
        panel.removeAll();

        // Define input fields for days and time
        JTextField daysForward = new JTextField();
        daysForward.setPreferredSize(new Dimension(200, 30));
        daysForward.setToolTipText("Enter a number from 0 to 6 (default 0)");

        JTextField timeHour = new JTextField();
        timeHour.setPreferredSize(new Dimension(200, 30));
        timeHour.setToolTipText("Enter time in HH:MM (24-hour format)");

        // Customize button appearance
        buttons[0].setFont(new Font("SansSerif", Font.PLAIN, 16));
        buttons[0].setBackground(new Color(173, 216, 230)); // Light blue background
        buttons[0].setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237))); // Blue border
        buttons[0].setFocusPainted(false);

        buttons[1].setFont(new Font("SansSerif", Font.PLAIN, 16));
        buttons[1].setBackground(new Color(173, 216, 230)); // Light blue background
        buttons[1].setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237))); // Blue border
        buttons[1].setFocusPainted(false);

        // Set up layout with constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally
        gbc.gridx = 0; // Column index
        gbc.weightx = 1.0; // Equal horizontal space distribution

        // Add components to the panel
        gbc.gridy = 0; // Row index
        panel.add(labels[0], gbc);

        gbc.gridy = 1;
        panel.add(daysForward, gbc);

        gbc.gridy = 2;
        panel.add(labels[1], gbc);

        gbc.gridy = 3;
        panel.add(timeHour, gbc);

        gbc.gridy = 4;
        panel.add(buttons[0], gbc);

        gbc.gridy = 5;
        panel.add(buttons[1],gbc);

        // Add button listener
        buttons[0].addActionListener(e -> {
            processData(daysForward.getText().trim(), timeHour.getText().trim());
        });
        buttons[1].addActionListener(e -> {
            frame.remove(panel);
            new MainMenu();
        });

        // Customize panel appearance
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(105, 105, 105), 2), // Dark gray outer border
                BorderFactory.createEmptyBorder(20, 20, 20, 20) // Internal padding
        ));
    }

    private int processData(String days, String hour) {
        // Validate and process input data
        Pattern daysPattern = Pattern.compile("(?<!\\-)([0-6]{1})");
        Matcher daysMatcher = daysPattern.matcher(days);

        if (days.isEmpty()) {
            days = "0";
        } else if (!daysMatcher.matches()) {
            JOptionPane.showMessageDialog(panel, "Invalid number of days. Enter a number between 0 and 6.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } else{
            days = daysMatcher.group(1);
        }

        

        // Validate time input
        Pattern timePattern = Pattern.compile("(?<!\\s)([0-9]{2}):([0-9]{2})");
        Matcher timeMatcher = timePattern.matcher(hour);

        if (!timeMatcher.matches()) {
            JOptionPane.showMessageDialog(panel, "Invalid time format. Use HH:MM in 24-hour format.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        int parsedHour = Integer.parseInt(timeMatcher.group(1));
        int parsedMinute = Integer.parseInt(timeMatcher.group(2));

        // Adjust hour based on minutes
        if (parsedHour > 24) parsedHour = 24;
        if (parsedHour < 0) parsedHour = 0;
        if (parsedMinute >= 30) parsedHour++;
        if (parsedHour > 24) parsedHour = 24;

        DateTime.getData(days, String.valueOf(parsedHour));

        // Switch to the main menu
        frame.remove(panel);
        new MainMenu();

        return 0;
    }
}
