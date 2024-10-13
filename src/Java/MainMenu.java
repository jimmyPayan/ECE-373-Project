

public class MainMenu {
    private MainMenuGUI menugui;

    public MainMenu(){
        menugui = new MainMenuGUI();
        menugui.placeOnPanel();
        menugui.placeOnScreen(); 
    }
    public static void toLogin(){
        System.out.println("Menu Call: Login");
        // Create instance of login class/gui
    }
    public static void toDate(){
        System.out.println("Menu Call: Date");
        //menugui.panel.removeAll();
        DateTime datetime = new DateTime();
    }
    public static void toSettings(){
        System.out.println("Menu Call: Settings");
        // Create instance of settings class/gui
        UserSettings usersettings = new UserSettings();
    }
    public static void toExit(){
        System.out.println("Menu Call: Exit");
        // Create instance of exit class/gui
    }

    public static void main(String Args[]){
        MainMenu menu = new MainMenu();
    }


}
