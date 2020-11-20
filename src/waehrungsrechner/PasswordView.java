package waehrungsrechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordView extends JFrame {
    private JPasswordField passwordField1;
    private JTextField usernameTextField;
    private JButton loginButton;
    private JPanel mainPanel;
    private JLabel wrongLoginField;


    public PasswordView() {
        super("Account by @Timo");
        mainPanel.setSize(100, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setSize(500, 200);
        setVisible(true);


        loginButton.addActionListener(e -> {

            if (createAccount("Timo", "1234") || createAccount("Nils", "1234")) {
                new WaehrungsPresenter(new WaehrungsView());
                setVisible(false);
            } else {
                wrongLoginField.setText("Wrong Login Data");
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            return false;
        });

        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });
    }

    public boolean createAccount(String username, String password) {
        return usernameTextField.getText().equalsIgnoreCase(username) && passwordField1.getText().equalsIgnoreCase(password);
    }


}
