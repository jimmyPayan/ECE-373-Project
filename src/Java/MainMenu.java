public class MainMenu {
    private MainMenuGUI menugui;

    public MainMenu(){
        // create gui instance
        menugui = new MainMenuGUI();
        menugui.placeOnPanel();
        menugui.placeOnScreen(); 
    }
    public static void toLogin(){
        System.out.println("Menu Call: Login");
        //TODO implement Ahmad's code later
    }
    public static void toDate(){
        // goto date class
        System.out.println("Menu Call: Date");
        DateTime datetime = new DateTime(true);
    }
    public static void toSettings(){
        // goto user settings class
        System.out.println("Menu Call: Settings");
        UserSettings usersettings = new UserSettings();
    }
    public static void toExit(){
        System.out.println("Menu Call: Exit");
        //TODO Implement Jimmy's code later
    }

    // for debug
    public static void main(String Args[]){
        MainMenu menu = new MainMenu();
    }


}
