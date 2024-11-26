import java.io.File;

public class Login {
    private LoginGUI gui;
    private static CredentialDatabase database = new CredentialDatabase(new File("DB.txt"));

    public Login(LoginGUI gui, CredentialDatabase database) {
        this.gui = gui;
        this.database = database;
    } 
    public static void proceedAsGuest() {
        System.out.println("go to next GUI");
    }
    public static void performLogin(String username, String password) {
        if(database.inDatabase(username, Encryptor.encrypt(password, 1))) {
            System.out.println("Account in system, go to next GUI");
        } else {
            System.out.println("Account does not exist");
        }
    }

    
}
