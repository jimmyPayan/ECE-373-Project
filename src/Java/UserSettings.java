public class UserSettings {
    public static String degree = "F";
    public static String color = "";
    public static String location = "";

    public UserSettings(){
        UserSettingsGUI gui = new UserSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }

    
}
