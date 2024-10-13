import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

public class UserSettingsGUI extends GUI {
    
    public UserSettingsGUI() {
        super(null, null, null);
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[3];
        buttons[0] = new JButton("Select Color");
        buttons[1] = new JButton("finish");
        buttons[2] = new JButton("Go"); //; change locaiton

        JLabel[] labels = new JLabel[3];
        // define labels
        labels[0] = new JLabel("Select Degree Unit:");
        labels[1] = new JLabel("Change color of dialog boxes:");
        labels[2] = new JLabel("Change Location");

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }


    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] degree_list = {"F", "C"}; 
        JComboBox<String> degree_sel = new JComboBox<String>(degree_list);
        degree_sel.setSelectedItem(UserSettings.degree);
        degree_sel.setMaximumSize(new Dimension(50, 30));

        panel.add(labels[0]);
        panel.add(degree_sel);
        panel.add(labels[1]);
        panel.add(buttons[0]);
        panel.add(labels[2]);
        panel.add(buttons[2]);

        panel.add(buttons[1]);
        

        buttons[0].addActionListener(e -> {
            System.out.println("SettingsCall: color");
            SwingUtilities.invokeLater(() -> new ColorSettingsApp());
            ColorSettings settings = new ColorSettings();
        });

        buttons[1].addActionListener(e -> {
            System.out.println("SettingsCall: MainMenu");
            UserSettings.degree = degree_list[degree_sel.getSelectedIndex()];
            frame.remove(panel);
            MainMenu menu = new MainMenu();
        });

        buttons[2].addActionListener(e -> {
            System.out.println("SettingsCall: location");
            // go to location settings ui
        });


    }

    public static void main(String[] args) {
        UserSettingsGUI gui = new UserSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }


}
