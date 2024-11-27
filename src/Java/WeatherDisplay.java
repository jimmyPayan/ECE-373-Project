public class WeatherDisplay {
    private WeatherDisplayGUI weatherGUI;

    public WeatherDisplay(){
        // create gui instance
        weatherGUI = new WeatherDisplayGUI();
        weatherGUI.placeOnPanel();
        weatherGUI.placeOnScreen(); 
    }
    public static void toLogin(){
        LoginGUI logingui = new LoginGUI();
        System.out.println("Menu Call: Login");
        logingui.placeOnPanel();
        logingui.placeOnScreen();
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
        Exit exit = new Exit(); // jp test
    }

    // for debug
    public static void main(String Args[]){
        WeatherDisplay weatherDisplay = new WeatherDisplay();
    }


}
