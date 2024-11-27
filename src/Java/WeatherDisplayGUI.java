import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class WeatherDisplayGUI extends GUI {
    // Jimmy: Not done!!!
    public WeatherDisplayGUI() {
        super(null, null, null);

        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[9];
        JLabel[] labels = new JLabel[9];
        
        // Days of the week should be larger buttons which display horizontally
        buttons[0]= new JButton("Sunday");
        buttons[1]= new JButton("Monday");
        buttons[2]= new JButton("Tuesday");
        buttons[3]= new JButton("Wednesday");
        buttons[4]= new JButton("Thursday");
        buttons[5]= new JButton("Friday");
        buttons[6]= new JButton("Saturday");

        // Exit/Main Menu should be located in top right.
        buttons[7]= new JButton("Exit");
        buttons[8]= new JButton("Main Menu");

        labels[0] = new JLabel("Sunday forecast");
        labels[1] = new JLabel("Monday forecast");
        labels[2] = new JLabel("Tuesday forecast");
        labels[3] = new JLabel("Wednesday forecast");
        labels[4] = new JLabel("Thursday forecast");
        labels[5] = new JLabel("Friday forecast");
        labels[6] = new JLabel("Saturday forecast");
        
        labels[7] = new JLabel("Quit Program");
        labels[8] = new JLabel("Return to Main Menu");

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }

    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints a = new GridBagConstraints();
        // Begin w/ days of the week; start at middle left and move over gradually
        a.anchor = GridBagConstraints.LINE_START;
        a.fill = GridBagConstraints.HORIZONTAL;
        a.gridx = 0;
        a.gridy = 1;
        a.weightx = 1;
        a.weighty = 1;
        a.gridwidth = 2;
        //a.insets = new Insets(5,5,0,0);
        a.ipady = 200; // todo: Change once there's more to add to the button!

        // display the days of the week :)
        for(int i = 0 ; i < 7 ; i++) {
        panel.add(this.buttons[i], a);
        a.gridx = a.gridx + 2;
        }

        // Top right corner for exit
        a.anchor = GridBagConstraints.FIRST_LINE_START;
        a.weightx = 0;
        a.gridx = 12;
        a.gridy = 0;
        a.ipady = 0;
        a.insets = new Insets(0,0,0,0);

        //panel.add(this.labels[7]);
        panel.add(this.buttons[7], a);

        a.gridx = 10;
        panel.add(this.buttons[8], a);
    }

    public static void main(String Args[]) {
        WeatherDisplay weatherDisplay = new WeatherDisplay();
    }

}