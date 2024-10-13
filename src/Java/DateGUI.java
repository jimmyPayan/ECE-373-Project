import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Dimension;



public class DateGUI extends GUI {
    public DateGUI(){//JPanel panel, JLabel[] labels, JButton[] buttons) {
        super(null, null, null);
        JPanel panel = new JPanel();
        JButton[] buttons = new JButton[1];
        // define button/s
        buttons[0] = new JButton("finish");


        JLabel[] labels = new JLabel[3];
        // define labels
        labels[0] = new JLabel("Forecast days ahead (max 6)");
        labels[1] = new JLabel("Current Time (24hr, HH:MM)");

        this.panel = panel;
        this.buttons = buttons;
        this.labels = labels;
    }

    public void placeOnPanel() {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // text fields for days and time
        JTextField daysForward = new JTextField();
        daysForward.setPreferredSize(new Dimension(200, 40));
        JTextField timehour = new JTextField();
        timehour.setPreferredSize(new Dimension(200, 40));

        // add to panel
        panel.add(labels[0]);
        panel.add(daysForward);
        panel.add(labels[1]);
        panel.add(timehour);
        panel.add(buttons[0]);

        // listener for finish button
        buttons[0].addActionListener(e -> {
            processData(daysForward.getText(), timehour.getText());
        });

    }

    private int processData(String days, String hour){
        // does input/format checking exits this function if data is incorrect
        // if data is correct, will return data to backend class

        // regex for number of days
        Pattern pattern = Pattern.compile("(?<!\\-)([0-6]{1})");
        Matcher matcher = pattern.matcher(days);
        if (days == "") days = "0";
        else if(!matcher.find()){
            JOptionPane.showMessageDialog(panel, "bad number of days entered", null, 0);
            return -1;
        }
        days = matcher.group(1);
        // emergency fallback, these shouldn't run
        if(Integer.valueOf(days) > 6) days = "6";
        if(Integer.valueOf(days) < 0) days = "0";

        // regex for time
        pattern = Pattern.compile("(?<!\\s)([0-9]{2}):([0-9]{2})");
        matcher = pattern.matcher(hour);
        if(!matcher.find()){
            JOptionPane.showMessageDialog(panel, "bad time entered", null, 0);
            return -1;
        }
        hour = matcher.group(1);
        // closest match for time, if oob
        if(Integer.valueOf(hour) > 24) hour = "24";
        if(Integer.valueOf(hour) < 0) hour = "0";
        if(Integer.valueOf(matcher.group(2)) >= 30) hour = String.valueOf(Integer.valueOf(hour) + 1);
        hour = (hour == "25") ? "24": hour;
        DateTime.getData(days, hour);

        frame.remove(panel);
        MainMenu menu = new MainMenu();

        return 0;
    }

    //public static void main(String Args[]){
    //    DateGUI dategui = new DateGUI();
    //    dategui.placeOnPanel();
    //    dategui.placeOnScreen();
    //}


}
