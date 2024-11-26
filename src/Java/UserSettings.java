public class UserSettings {
    // defaults to Fahrenheit
    // no color or location initially
    public static String degree = "F";
    public static String color = "";
    public static String location = "";

    public UserSettings(){
        // create gui instance
        UserSettingsGUI gui = new UserSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }

    public static void toLocation(){
        // implement Aayush's code later
    }

    public static void toColor(){
        // implement Aayush's code later
        ColorSettings settings = new ColorSettings();
    }

    public static void toMenu(){
        // back to menu
        MainMenu menu = new MainMenu();
    }

    
}
