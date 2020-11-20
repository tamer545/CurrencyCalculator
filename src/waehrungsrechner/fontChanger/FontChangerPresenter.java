package waehrungsrechner.fontChanger;

import waehrungsrechner.FontChangerView;

import java.awt.*;

public class FontChangerPresenter {
    private FontChangerView view;

    public FontChangerPresenter(FontChangerView view){
        this.view = view;
        view.setPresenter(this);
    }

    public void generate(FontChangerEnum comboBoxEnum){
        switch (comboBoxEnum) {
            case AcmeFont -> view.setOutputFont(new Font("AcmeFont", Font.BOLD, 14));
            case Bauhaus93 -> view.setOutputFont(new Font("Bauhaus93", Font.BOLD, 14));


        };
        view.setOutput();

    }
}
