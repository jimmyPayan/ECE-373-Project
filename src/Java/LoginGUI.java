import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.*;

public class LoginGUI extends GUI {
    private JTextField usernameInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();


    public LoginGUI() {
        super(null, null, null);
        JPanel panel = new JPanel();

        JButton[] buttons = new JButton[3];
        buttons[0] = new JButton("Returning User");
        buttons[1] = new JButton("Guest");
        buttons[2] = new JButton("Main Menu");
        JLabel[] labels = new JLabel[3];
        labels[0] = new JLabel("Log in as Returning User");
        labels[1] = new JLabel("Continue as Guest");
        labels[2] = new JLabel("Return to Main Menu");
        
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
        
        panel.add(new JLabel("Username:"));
        passwordInput.setEchoChar('-');
        panel.add(this.usernameInput);
        panel.add(new JLabel("Password:"));
        panel.add(this.passwordInput);

        for(int i = 1; i < labels.length; i++) {
            panel.add(this.labels[i]);
            panel.add(this.buttons[i]);
        }
        
        buttons[0].addActionListener(e -> {
            System.out.println("Login attempt");
            if (Login.performLogin(usernameInput.getText(), passwordInput.getText())) {
                frame.remove(panel);
            // Display weather data gui
            }
            else {
            JOptionPane.showMessageDialog(panel, "Incorrect username or password. Please try again.", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttons[1].addActionListener(e -> {
            System.out.println("Proceed as Guest");
            Login.proceedAsGuest();
            frame.remove(panel);
            // Display weather data gui
        });

        buttons[2].addActionListener(e -> {
            frame.remove(panel);
            Login.goToMain();
        });

    }
    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }
}