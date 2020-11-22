package waehrungsrechner;

import waehrungsrechner.currenciesCalculator.WaehrungsEnum;
import waehrungsrechner.currenciesCalculator.WaehrungsPresenter;
import waehrungsrechner.fontChanger.FontChangerPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WaehrungsView extends JFrame {
    private WaehrungsPresenter presenter;
    private JTextField frTextField;
    private JPanel mainPanel;
    private JButton calculateButton;
    private JComboBox currenciesComboBox;
    private JLabel CHFLabel;
    private JLabel waehrungTextLabel;
    private JLabel errorLabel;
    private JButton returnToLoginButton;

    public WaehrungsView() {
        super("Währungsrechner by @Timo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        setSize(700, 250);
        setVisible(true);

        currenciesComboBox.add(new JScrollPane());

        currenciesComboBox.addItem(WaehrungsEnum.CHF);
        currenciesComboBox.addItem(WaehrungsEnum.GBP);
        currenciesComboBox.addItem(WaehrungsEnum.EURO);
        currenciesComboBox.addItem(WaehrungsEnum.JPY);
        currenciesComboBox.addItem(WaehrungsEnum.USD);
        currenciesComboBox.addItem(WaehrungsEnum.CAD);
        currenciesComboBox.addItem(WaehrungsEnum.SAR);
        currenciesComboBox.addItem(WaehrungsEnum.SKR);
        currenciesComboBox.addItem(WaehrungsEnum.CNH);

        frTextField.requestFocus();

        calculateButton.addActionListener(e -> presenter.calculate(frTextField.getText(), (WaehrungsEnum) currenciesComboBox.getSelectedItem()));

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
                if (e.getKeyCode() == KeyEvent.VK_F) {
                    setVisible(false);
                    new FontChangerPresenter(new FontChangerView());
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setVisible(false);
                    currenciesComboBox.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    setVisible(false);
                    new PasswordView();
                }
            }
        });
        currenciesComboBox.addKeyListener(new KeyAdapter() {

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
