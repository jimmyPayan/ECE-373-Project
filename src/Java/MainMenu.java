

public class MainMenu {
    private MainMenuGUI menugui;

    public MainMenu(){
        menugui = new MainMenuGUI();
        menugui.placeOnPanel();
        menugui.placeOnScreen(); 
    }
    public static void toLogin(){
        System.out.println("Menu Call: Login");
    }
    public static void toDate(){
        System.out.println("Menu Call: Date");
    }
    public static void toSettings(){
        System.out.println("Menu Call: Settings");
    }
    public static void toExit(){
        System.out.println("Menu Call: Exit");
    }

    public static void main(String Args[]){
        MainMenu menu = new MainMenu();
    }


}
