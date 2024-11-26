import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.*;

public class MainMenuGUI extends GUI {

    public MainMenuGUI(){
        super(null, null, null);
        
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[4];
        // define buttons
        buttons[0] = new JButton("LoginGUI");
        buttons[1] = new JButton("DateGUI");
        buttons[2] = new JButton("UserSettingsGUI");
        buttons[3] = new JButton("ExitGUI");

        JLabel[] labels = new JLabel[4];
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

    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for(int i = 0; i < labels.length; i++){
            panel.add(this.labels[i]);
            panel.add(this.buttons[i]);
        }
        
        //listener events
        buttons[0].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "to login", null, JOptionPane.INFORMATION_MESSAGE);
            //todo frame.remove(panel); // uncomment once implemented
            frame.remove(panel);
            MainMenu.toLogin();
        });
        buttons[1].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "to date", null, JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            MainMenu.toDate();
        });
        buttons[2].addActionListener(e -> {
           // JOptionPane.showMessageDialog(panel, "to settings", null, JOptionPane.INFORMATION_MESSAGE);
            frame.remove(panel);
            MainMenu.toSettings();
        });
        buttons[3].addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "exit", null, JOptionPane.INFORMATION_MESSAGE);
            //todo frame.remove(panel); // uncomment once implemented
            MainMenu.toExit();
        });
    }
}
