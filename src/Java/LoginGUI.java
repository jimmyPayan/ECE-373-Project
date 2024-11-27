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
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username and password fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(new JLabel("Username:"), gbc);
        gbc.gridy++;
        panel.add(usernameInput, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        passwordInput.setEchoChar('*');
        panel.add(passwordInput, gbc);

        // Buttons and labels
        gbc.gridwidth = 1;
        for (int i = 0; i < labels.length; i++) {
            gbc.gridy++;
            panel.add(labels[i], gbc);
            gbc.gridx = 1;
            panel.add(buttons[i], gbc);
            gbc.gridx = 0;
        }

        // Button actions
        buttons[0].addActionListener(e -> {
            System.out.println("Login attempt");
            if (Login.performLogin(usernameInput.getText(), new String(passwordInput.getPassword()))) {
                frame.remove(panel);
                // Display weather data GUI
            } else {
                JOptionPane.showMessageDialog(panel,
                        "Incorrect username or password. Please try again.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        buttons[1].addActionListener(e -> {
            System.out.println("Proceed as Guest");
            Login.proceedAsGuest();
            frame.remove(panel);
            // Display weather data GUI
        });

        buttons[2].addActionListener(e -> {
            frame.remove(panel);
            Login.goToMain();
        });

        this.panel.setBackground(new Color(245, 245, 245)); // Light gray background
    }


    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }
}