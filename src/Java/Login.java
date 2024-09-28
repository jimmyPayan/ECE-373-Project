public class Login {
    private LoginGUI gui;
    private CredentialDatabase database;

    public Login(LoginGUI gui, CredentialDatabase database) {
        this.gui = gui;
        this.database = database;
    } 
    public static void performLogin() {
        System.out.println("Login button clicked! Perform login action here.");
    }

    
}
