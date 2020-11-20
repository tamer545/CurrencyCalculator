package waehrungsrechner.fontChanger;

import waehrungsrechner.FontChangerView;

import java.awt.*;

public class FontChangerPresenter {
    private FontChangerView view;

    public FontChangerPresenter(FontChangerView view){
        this.view = view;
        view.setPresenter(this);
    }

    public void generate(String inputText, FontChangerEnum comboBoxEnum){

        switch (comboBoxEnum) {
            case AcmeFont -> view.setOutputFont(new Font("AcmeFont", Font.BOLD, 12));


        };
        view.setOutput();

    }
}
