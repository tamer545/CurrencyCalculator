package waehrungsrechner;

import waehrungsrechner.fontChanger.FontChangerEnum;
import waehrungsrechner.fontChanger.FontChangerPresenter;
import javax.swing.*;
import java.awt.*;


public class FontChangerView extends JFrame {
    private FontChangerPresenter presenter;
    private JPanel mainPanel;
    private JComboBox fontComboBox;
    private JTextField inputText;
    private JButton generateTextButton;
    private JLabel outputTextLabel;

    public FontChangerView() {
        super("Font Changer by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(700, 250);
        setVisible(true);

        fontComboBox.add(new JScrollPane());

        fontComboBox.addItem(FontChangerEnum.AcmeFont);
        fontComboBox.addItem(FontChangerEnum.Bauhaus93);


        generateTextButton.addActionListener(e -> presenter.generate((FontChangerEnum) fontComboBox.getSelectedItem()));
    }
    public void setPresenter(FontChangerPresenter presenter) {
        this.presenter = presenter;
    }
    public void setOutputFont(Font font){
        outputTextLabel.setFont(font);
    }
    public void setOutput(){
        outputTextLabel.setText(inputText.getText());
    }
}