import javafx.embed.swing.JFXPanel;
import moaimoai.GameWindow;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        final JFXPanel fxPanel = new JFXPanel();
        gameWindow.loop();
    }
}
