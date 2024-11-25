import java.io.File;

public class Login {
    private LoginGUI gui;
    private static CredentialDatabase database = new CredentialDatabase(new File("DB.txt"));

    // empty constructor
    public Login() {
        gui = new LoginGUI();
        gui.placeOnPanel();
        gui.placeOnScreen(); 
    }
    
    public Login(LoginGUI gui, CredentialDatabase database) {
        this.gui = gui;
    } 
    public static void performLogin(String user, String pass) {
        if(database.inDatabase(user, Encryptor.encrypt(pass, 1))) {
            System.out.println("Password in system, go to next GUI");
        } else {
            database.addEntry(user, Encryptor.encrypt(pass, 1));
            performLogin(user, Encryptor.encrypt(pass, 1));
        }
    }

    public static void toMainMenu(){
        MainMenu menu = new MainMenu();
    }

    public static void main(String Args[]){
        Login login = new Login();
    }
}    

