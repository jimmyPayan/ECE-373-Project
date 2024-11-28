import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WeatherDisplayGUI extends GUI {
    private WeatherData[] weatherDataArray;

    public WeatherDisplayGUI(WeatherData[] weatherDataArray) {
        super(null, null, null);
        
        this.weatherDataArray = weatherDataArray;

        // Set up main panel
        JPanel panel = new JPanel(new BorderLayout());
        this.panel = panel;

        // Table setup
        String[] columnNames = {"Day", "Precipitation (%)", "Temperature (°C)", "Wind Speed (km/h)"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Fill table with data
        for (int i = 0; i < weatherDataArray.length; i++) {
            WeatherData data = weatherDataArray[i];
            String[] row = {
                "Day " + (i + 1),
                String.format("%.1f", data.getPrecipitation()),
                String.format("%.1f", data.getTemperature()),
                String.format("%.1f", data.getWindSpeed())
            };
            tableModel.addRow(row);
        }

        JTable weatherTable = new JTable(tableModel);
        weatherTable.setEnabled(false); // Make the table non-editable
        weatherTable.setRowHeight(30);
        weatherTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        weatherTable.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(weatherTable);

        // Title label
        JLabel titleLabel = new JLabel("5-Day Weather Forecast");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Add components to panel
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        backButton.addActionListener(e -> {
            frame.remove(panel);
            new MainMenu();
        });

        panel.add(backButton, BorderLayout.SOUTH);

        // Style panel
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public void placeOnPanel() {
        frame.add(panel);
    }
}
