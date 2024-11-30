import java.io.File;

import javax.swing.JOptionPane;

public class Login {
    private LoginGUI gui;
    private static CredentialDatabase database = new CredentialDatabase(new File("DB.txt"));

    public Login(LoginGUI gui, CredentialDatabase database) {
        this.gui = gui;
        this.database = database;
    } 
    public static void proceedAsGuest() {
        System.out.println("go to next GUI");
        String lat = JOptionPane.showInputDialog("Enter latitude:");
        String lon = JOptionPane.showInputDialog("Enter longitude:");
        WeeklyWeatherForecast.updatePeriods(lat, lon);
        WeatherDisplayGUI weatherDisplay = new WeatherDisplayGUI(WeeklyWeatherForecast.getNextFiveDaysWeatherData());
        weatherDisplay.placeOnPanel();
        weatherDisplay.placeOnScreen();
    }
    public static boolean performLogin(String username, String password) {
        if(database.inDatabase(username, Encryptor.encrypt(password, 1))) {
            System.out.println("Account in system, go to next GUI");
            //TODO: MAKE THIS THE NEXT GUI
            System.out.println("go to next GUI");
            String lat = JOptionPane.showInputDialog("Enter latitude:");
            String lon = JOptionPane.showInputDialog("Enter longitude:");
            WeeklyWeatherForecast.updatePeriods(lat, lon);
            WeatherDisplayGUI weatherDisplay = new WeatherDisplayGUI(WeeklyWeatherForecast.getNextFiveDaysWeatherData());
            weatherDisplay.placeOnPanel();
            weatherDisplay.placeOnScreen();
            return true;
        } 
        
        else {
            System.out.println("Account does not exist");
            return false;
        }
    }
    public static void goToMain() {
        System.out.println("Going to main menu");
        MainMenu mainMenu = new MainMenu();
    }
    public static void createAccount(String user, String pass) {
        database.addEntry(user, pass);
    }
    
}
