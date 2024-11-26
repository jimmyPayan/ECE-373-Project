public class ColorSettings {
    public static String selectedColor = "Default";

    public ColorSettings() {
        // Constructor for setting up color settings
        display();
    }

    public void display() {
        // Create GUI for Color Settings
        ColorSettingsGUI gui = new ColorSettingsGUI();
        gui.placeOnPanel();
        gui.placeOnScreen();
    }
    public static void toUserSettings(){
        UserSettings usersettings = new UserSettings();
    }

    public static void saveColor(String color) {
        selectedColor = color;
        System.out.println("Color set to: " + color);
    }
}