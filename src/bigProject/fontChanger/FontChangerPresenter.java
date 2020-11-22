package bigProject.fontChanger;

import bigProject.FontChangerView;

import java.awt.*;

public class FontChangerPresenter {
    private FontChangerView view;

    public FontChangerPresenter(FontChangerView view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void generate(FontChangerEnum comboBoxEnum) {
        switch (comboBoxEnum) {
            case AcmeFont -> view.setOutputFont(new Font("AcmeFont", Font.BOLD, 14));
            case AlienEncounters -> view.setOutputFont(new Font("Alien Encounters", Font.BOLD, 14));
            case BabyKruffy -> view.setOutputFont(new Font("Baby Kruffy", Font.BOLD, 14));
            case Bauhaus93 -> view.setOutputFont(new Font("Bauhaus 93", Font.BOLD, 14));
            case Brandish -> view.setOutputFont(new Font("Brandish", Font.BOLD, 14));
            case DroidSansMono -> view.setOutputFont(new Font("Droid Sans Mono", Font.BOLD, 14));
            case EngraversMT -> view.setOutputFont(new Font("Engravers MT", Font.BOLD, 14));
            case Monospaced -> view.setOutputFont(new Font("Monospaced", Font.BOLD, 14));
            case NeonLights -> view.setOutputFont(new Font("Neon Lights", Font.BOLD, 14));
            case Tarzan -> view.setOutputFont(new Font("Tarzan", Font.BOLD, 14));
            case VenusRising -> view.setOutputFont(new Font("Venus Rising", Font.BOLD, 14));
            case Woodcut -> view.setOutputFont(new Font("Woodcut", Font.BOLD, 14));


        }
        ;
        view.setOutput();

    }

    public void setFont(FontChangerEnum comboBoxEnum) {
        switch (comboBoxEnum) {
            case AcmeFont -> view.setFontEveryhwere(new Font("AcmeFont", Font.BOLD, 12));
            case AlienEncounters -> view.setFontEveryhwere(new Font("Alien Encounters", Font.BOLD, 12));
            case BabyKruffy -> view.setFontEveryhwere(new Font("Baby Kruffy", Font.BOLD, 12));
            case Bauhaus93 -> view.setFontEveryhwere(new Font("Bauhaus 93", Font.BOLD, 12));
            case Brandish -> view.setFontEveryhwere(new Font("Brandish", Font.BOLD, 12));
            case DroidSansMono -> view.setFontEveryhwere(new Font("Droid Sans Mono", Font.BOLD, 12));
            case EngraversMT -> view.setFontEveryhwere(new Font("Engravers MT", Font.BOLD, 12));
            case Monospaced -> view.setFontEveryhwere(new Font("Monospaced", Font.BOLD, 12));
            case NeonLights -> view.setFontEveryhwere(new Font("Neon Lights", Font.BOLD, 12));
            case Tarzan -> view.setFontEveryhwere(new Font("Tarzan", Font.BOLD, 12));
            case VenusRising -> view.setFontEveryhwere(new Font("Venus Rising", Font.BOLD, 12));
            case Woodcut -> view.setFontEveryhwere(new Font("Woodcut", Font.BOLD, 12));


        }
        ;

    }
}