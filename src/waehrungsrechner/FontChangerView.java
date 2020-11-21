package waehrungsrechner;

import waehrungsrechner.fontChanger.FontChangerEnum;
import waehrungsrechner.fontChanger.FontChangerPresenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FontChangerView extends JFrame {
    private FontChangerPresenter presenter;
    private JPanel mainPanel;
    private JComboBox fontComboBox;
    private JTextField inputText;
    private JButton generateTextButton;
    private JTextField outputTextField;

    public FontChangerView() {
        super("Font Changer by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(700, 250);
        setVisible(true);

        fontComboBox.add(new JScrollPane());

        fontComboBox.addItem(FontChangerEnum.AcmeFont);
        fontComboBox.addItem(FontChangerEnum.BabyKruffy);
        fontComboBox.addItem(FontChangerEnum.Bauhaus93);
        fontComboBox.addItem(FontChangerEnum.Monospaced);


        generateTextButton.addActionListener(e -> presenter.generate((FontChangerEnum) fontComboBox.getSelectedItem()));

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
    }
    public void setPresenter(FontChangerPresenter presenter) {
        this.presenter = presenter;
    }
    public void setOutputFont(Font font){
        outputTextField.setFont(font);
    }
    public void setOutput(){
        outputTextField.setText(inputText.getText());
    }
}