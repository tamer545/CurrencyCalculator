package waehrungsrechner;

import waehrungsrechner.fontChanger.FontChangerEnum;
import waehrungsrechner.fontChanger.FontChangerPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FontChangerView extends JFrame {
    private FontChangerPresenter presenter;
    private JPanel mainPanel;
    private JComboBox fontComboBox;
    private JTextField inputText;
    private JButton generateTextButton;
    private JTextField outputTextField;
    private JButton returnToLoginButton;
    private JButton setFontButton;
    private JCheckBox darkModeCheckBox;
    private JLabel inputTextLabel;
    private JLabel outputTextLabel;

    public FontChangerView() {
        super("Font Changer by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setSize(800, 350);
        setVisible(true);

        fontComboBox.add(new JScrollPane());

        fontComboBox.addItem(FontChangerEnum.AcmeFont);
        fontComboBox.addItem(FontChangerEnum.AlienEncounters);
        fontComboBox.addItem(FontChangerEnum.BabyKruffy);
        fontComboBox.addItem(FontChangerEnum.Bauhaus93);
        fontComboBox.addItem(FontChangerEnum.Brandish);
        fontComboBox.addItem(FontChangerEnum.DroidSansMono);
        fontComboBox.addItem(FontChangerEnum.EngraversMT);
        fontComboBox.addItem(FontChangerEnum.Monospaced);
        fontComboBox.addItem(FontChangerEnum.NeonLights);
        fontComboBox.addItem(FontChangerEnum.Tarzan);
        fontComboBox.addItem(FontChangerEnum.VenusRising);
        fontComboBox.addItem(FontChangerEnum.Woodcut);


        generateTextButton.addActionListener(e -> presenter.generate((FontChangerEnum) fontComboBox.getSelectedItem()));

        returnToLoginButton.addActionListener(e -> {
            new PasswordView();
            setVisible(false);

        });

        inputText.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generateTextButton.doClick();
                }
            }
        });
        fontComboBox.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generateTextButton.doClick();
                }
            }
        });
        darkModeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (darkModeCheckBox.isSelected()) {
                    mainPanel.setBackground(Color.DARK_GRAY);
                    inputText.setBackground(Color.DARK_GRAY);
                    inputText.setForeground(Color.WHITE);
                    outputTextField.setBackground(Color.DARK_GRAY);
                    outputTextField.setForeground(Color.WHITE);
                    fontComboBox.setBackground(Color.DARK_GRAY);
                    fontComboBox.setForeground(Color.WHITE);
                    generateTextButton.setBackground(Color.DARK_GRAY);
                    generateTextButton.setForeground(Color.WHITE);
                    returnToLoginButton.setBackground(Color.DARK_GRAY);
                    returnToLoginButton.setForeground(Color.WHITE);
                    setFontButton.setBackground(Color.DARK_GRAY);
                    setFontButton.setForeground(Color.WHITE);
                    inputTextLabel.setForeground(Color.WHITE);
                    outputTextLabel.setForeground(Color.WHITE);
                    darkModeCheckBox.setForeground(Color.WHITE);
                    darkModeCheckBox.setBackground(Color.BLACK);
                } else {
                    mainPanel.setBackground(new Color(94, 118, 138));
                    inputText.setBackground(Color.WHITE);
                    inputText.setForeground(Color.BLACK);
                    outputTextField.setBackground(Color.WHITE);
                    outputTextField.setForeground(Color.BLACK);
                    fontComboBox.setBackground(Color.WHITE);
                    fontComboBox.setForeground(Color.BLACK);
                    generateTextButton.setBackground(new Color(66, 129, 157));
                    generateTextButton.setForeground(Color.BLACK);
                    returnToLoginButton.setBackground(new Color(66, 129, 157));
                    returnToLoginButton.setForeground(Color.BLACK);
                    setFontButton.setBackground(new Color(66, 129, 157));
                    setFontButton.setForeground(Color.BLACK);
                    inputTextLabel.setForeground(new Color(187, 187, 187));
                    outputTextLabel.setForeground(new Color(187, 187, 187));
                    darkModeCheckBox.setForeground(Color.BLACK);
                    darkModeCheckBox.setBackground(new Color(66, 129, 157));
                }
            }
        });
        setFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.setFont((FontChangerEnum) fontComboBox.getSelectedItem());
            }
        });
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                returnToLoginButton.doClick();
            }
            return false;
        });


    }

    public void setPresenter(FontChangerPresenter presenter) {
        this.presenter = presenter;
    }

    public void setOutputFont(Font font) {
        outputTextField.setFont(font);
    }

    public void setOutput() {
        outputTextField.setText(inputText.getText());
    }

    public void setFontEveryhwere(Font font) {
        fontComboBox.setFont(font);
        generateTextButton.setFont(font);
        returnToLoginButton.setFont(font);
        setFontButton.setFont(font);
        outputTextField.setFont(font);
    }

}