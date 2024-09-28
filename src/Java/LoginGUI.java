import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
public class LoginGUI extends GUI {
    public LoginGUI() {
        super(null, null, null);
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton("Login");
        buttons[1] = new JButton("Return to Main Menu");
        JLabel[] labels = new JLabel[2];
        labels[0] = new JLabel("Click below to login");
        labels[1] = new JLabel("Click to return to Main Menu");
        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }
}
