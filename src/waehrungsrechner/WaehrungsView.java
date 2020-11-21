package waehrungsrechner;

import waehrungsrechner.currenciesCalculator.WaehrungsEnum;
import waehrungsrechner.currenciesCalculator.WaehrungsPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WaehrungsView extends JFrame {
    private WaehrungsPresenter presenter;
    private JTextField frTextField;
    private JPanel mainPanel;
    private JButton calculateButton;
    private JComboBox comboBox2;
    private JLabel CHFLabel;
    private JLabel waehrungTextLabel;
    private JLabel errorLabel;
    private JButton returnToLoginButton;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public WaehrungsView() {
        super("Währungsrechner by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setContentPane(mainPanel);
        setSize(700, 250);
        setVisible(true);

        comboBox2.add(new JScrollPane());

        comboBox2.addItem(WaehrungsEnum.CHF);
        comboBox2.addItem(WaehrungsEnum.GBP);
        comboBox2.addItem(WaehrungsEnum.EURO);
        comboBox2.addItem(WaehrungsEnum.JPY);
        comboBox2.addItem(WaehrungsEnum.USD);
        comboBox2.addItem(WaehrungsEnum.CAD);
        comboBox2.addItem(WaehrungsEnum.SAR);
        comboBox2.addItem(WaehrungsEnum.SKR);
        comboBox2.addItem(WaehrungsEnum.CNH);

        calculateButton.addActionListener(e -> presenter.calculate(frTextField.getText(), (WaehrungsEnum) comboBox2.getSelectedItem()));

        returnToLoginButton.addActionListener(e -> {
            new PasswordView();
            setVisible(false);
        });

        frTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateButton.doClick();
                }
            }
        });
        comboBox2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateButton.doClick();
                }
            }
        });

    }

    public void setPresenter(WaehrungsPresenter presenter) {
        this.presenter = presenter;
    }

    public void setWaehrung(double waehrung) {
        waehrungTextLabel.setText(String.format("%.2f", waehrung));
    }

    public void setErrorLabel(String errorMessage) {
        errorLabel.setText(errorMessage);
    }
}
