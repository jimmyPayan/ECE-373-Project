import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;


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
    
    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for(int i = 0; i < labels.length; i++) {
            panel.add(this.labels[i]);
            panel.add(this.buttons[i]);
        }
        buttons[0].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "to login", null, JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            Login.performLogin();
        });
        buttons[1].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "to main menu", null, JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            Login.toMainMenu();
        });
    }
}
