import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
public class WeatherDisplayGUI extends GUI {
    // Jimmy: Not done!!!
    public WeatherDisplayGUI(JPanel panel, JLabel[] labels, JButton[] buttons) {
        super(null, null, null);

        JPanel = new JPanel();
        JButton = new JButton[9];
        
        JButton[0]="Sunday";
        JButton[1]="Monday";
        JButton[2]="Tuesday";
        JButton[3]="Wednesday";
        JButton[4]="Thursday";
        JButton[5]="Friday";
        JButton[6]="Saturday";

        JButton[7]="Exit";
        JButton[8]="Main Menu";

        // define labels
        labels[0] = new JLabel("LoginGUI label");
        labels[1] = new JLabel("DateGUI label");
        labels[2] = new JLabel("UserSettingsGUI label");
        labels[3] = new JLabel("ExitGUI label");

        this.panel = panel;
        panel.setBackground(Color.BLUE);
        this.buttons = buttons;
        this.labels = labels;
    }
}