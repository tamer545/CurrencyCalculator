package bigProject;

import bigProject.currenciesCalculator.WaehrungsPresenter;
import bigProject.fontChanger.FontChangerEnum;
import bigProject.fontChanger.FontChangerPresenter;

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

    private boolean isDarkModeOn = false;
    private Color darkTurkis = new Color(66, 129, 157);
    private Color turkis = new Color(94, 118, 138);
    private Color white = new Color(187, 187, 187);

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

        inputText.requestFocus();

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
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    setVisible(false);
                    new WaehrungsPresenter(new WaehrungsView());
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    setVisible(false);
                    returnToLoginButton.doClick();
                }
            }
        });
        fontComboBox.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generateTextButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    setVisible(false);
                    returnToLoginButton.doClick();
                }
            }
        });


        darkModeCheckBox.addActionListener(e -> {
            if (darkModeCheckBox.isSelected()) {
                mainPanel.setBackground(Color.DARK_GRAY);
                inputText.setBackground(Color.DARK_GRAY);
                inputText.setForeground(white);
                outputTextField.setBackground(Color.DARK_GRAY);
                outputTextField.setForeground(white);
                fontComboBox.setBackground(Color.DARK_GRAY);
                fontComboBox.setForeground(white);
                generateTextButton.setBackground(Color.DARK_GRAY);
                generateTextButton.setForeground(white);
                returnToLoginButton.setBackground(Color.DARK_GRAY);
                returnToLoginButton.setForeground(white);
                setFontButton.setBackground(Color.DARK_GRAY);
                setFontButton.setForeground(white);
                inputTextLabel.setForeground(white);
                outputTextLabel.setForeground(white);
                darkModeCheckBox.setForeground(white);
                darkModeCheckBox.setBackground(white);

                isDarkModeOn = true;
            } else {
                mainPanel.setBackground(turkis);
                inputText.setBackground(white);
                inputText.setForeground(Color.BLACK);
                outputTextField.setBackground(white);
                outputTextField.setForeground(Color.BLACK);
                fontComboBox.setBackground(white);
                fontComboBox.setForeground(Color.BLACK);
                generateTextButton.setBackground(darkTurkis);
                generateTextButton.setForeground(Color.BLACK);
                returnToLoginButton.setBackground(darkTurkis);
                returnToLoginButton.setForeground(Color.BLACK);
                setFontButton.setBackground(darkTurkis);
                setFontButton.setForeground(Color.BLACK);
                inputTextLabel.setForeground(white);
                outputTextLabel.setForeground(white);
                darkModeCheckBox.setForeground(Color.BLACK);
                darkModeCheckBox.setBackground(darkTurkis);
            }
        });
        setFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.setFont((FontChangerEnum) fontComboBox.getSelectedItem());
            }
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