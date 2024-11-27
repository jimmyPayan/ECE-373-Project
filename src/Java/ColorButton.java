import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Color;

public class ColorButton extends JButton{
    public static Color color = Color.white;
    public ColorButton() {
        super();
        this.setBackground(color);
    }
    public ColorButton(String b) {
        super(b);
        this.setBackground(color);
    }
    public ColorButton(Icon c) {
        super(c);
        this.setBackground(color);
    }
    public ColorButton(String a, Icon b){
        super(a,b);
        this.setBackground(color);
    }

}
