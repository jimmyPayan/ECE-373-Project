public class Login {
    private LoginGUI gui;
    private static CredentialDatabase database;

    // empty constructor
    public Login() {
        gui = new LoginGUI();
        gui.placeOnPanel();
        gui.placeOnScreen(); 
    }
    
    public Login(LoginGUI gui, CredentialDatabase database) {
        this.gui = gui;
        this.database = database;
    } 

    public static void performLogin() {
        if(database.inDatabase("Username", Encryptor.encrypt("Password", 1))) {
            System.out.println("Password in system, go to next GUI");
        }
    }

    public static void toMainMenu(){
        MainMenu menu = new MainMenu();
    }

    public static void main(String Args[]){
        Login login = new Login();
    }
}    

