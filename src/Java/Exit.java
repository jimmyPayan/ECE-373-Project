
public class Exit {
    private ExitGUI gui;

    public Exit() {

        gui = new ExitGUI();
        gui.placeOnPanel();
        gui.placeOnScreen(); 
    }

    public static void toExit() {
        System.exit(0);
    }

    public static void toMainMenu(){
        MainMenu menu = new MainMenu();
    }
    
    public static void main(String Args[]){
        Exit exit = new Exit();
    }
}
