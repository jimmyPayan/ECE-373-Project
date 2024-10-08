import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GUI {
    protected static JFrame frame = new JFrame();
    protected JLabel[] labels;
    protected JButton[] buttons;
    protected JPanel panel;
    public GUI(JPanel panel, JLabel[] labels, JButton[] buttons) {
        this.labels = labels;
        this.buttons = buttons;
        this.panel = panel;
    }
    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for(int i = 0; i < labels.length; i++) {
            panel.add(this.labels[i]);
            panel.add(this.buttons[i]);
        }
    }
    public void placeOnScreen() {
        frame.setSize(500,500);
        frame.add(this.panel);
        frame.setVisible(true);
    }
    public JButton[] getButtons() {
        return buttons;
    }
}
