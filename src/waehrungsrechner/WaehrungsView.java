package waehrungsrechner;

import waehrungsrechner.currenciesCalculator.WaehrungsEnum;
import waehrungsrechner.currenciesCalculator.WaehrungsPresenter;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WaehrungsView extends JFrame {
    private WaehrungsPresenter presenter;
    private JTextField frTextField;
    private JPanel mainPanel;
    private JButton calculateButton;
    private JComboBox comboBox2;
    private JLabel CHFLabel;
    private JLabel loggedInLabel;
    private JLabel waehrungTextLabel;
    private JLabel errorLabel;

    public WaehrungsView() {
        super("Währungsrechner by @Timo");
        loggedInLabel.setText("Currently using the premium Version");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(700, 250);
        pack();
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

        frTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                calculateButton.doClick();
            }
        });
        comboBox2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                calculateButton.doClick();
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
