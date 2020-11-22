package waehrungsrechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBindsView extends JFrame {
    private JPanel mainPanel;


    public KeyBindsView() {
        super("Account by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setSize(500, 200);
        setVisible(true);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                setVisible(false);
                new PasswordView();
            }
            return false;
        });
    }

}