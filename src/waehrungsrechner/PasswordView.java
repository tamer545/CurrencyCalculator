package waehrungsrechner;

import waehrungsrechner.currenciesCalculator.WaehrungsPresenter;
import waehrungsrechner.fontChanger.FontChangerPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordView extends JFrame {
    private JPasswordField passwordTextField;
    private JTextField usernameTextField;
    private JButton loginButton;
    private JPanel mainPanel;
    private JLabel wrongLoginField;
    private JComboBox loginComboBox;
    private JButton openSettingsButton;

    public PasswordView() {
        super("Account by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setSize(500, 200);
        setVisible(true);

        loginComboBox.addItem("Font Changer");
        loginComboBox.addItem("Currencies Calculator");


        loginButton.addActionListener(e -> {

            if (createAccount("Timo", "1234") || createAccount("Nils", "1234") || createAccount("Matija", "1234")) {
                setVisible(false);

                if (loginComboBox.getSelectedItem().equals("Font Changer")) {
                    new FontChangerPresenter(new FontChangerView());
                } else {
                    new WaehrungsPresenter(new WaehrungsView());
                }

            } else {
                wrongLoginField.setText("Wrong Login Data");
            }
        });
        openSettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new KeyBindsView();
            }
        });


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            return false;
        });

        usernameTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordTextField.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setVisible(false);
                    new KeyBindsView();
                }
            }
        });

        passwordTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    loginComboBox.requestFocus();
                }
            }
        });

        loginComboBox.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });


    }

    public boolean createAccount(String username, String password) {
        return usernameTextField.getText().equalsIgnoreCase(username) && passwordTextField.getText().equalsIgnoreCase(password);
    }


}
