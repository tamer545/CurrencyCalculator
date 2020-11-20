package waehrungsrechner;

public class WaehrungsPresenter {

    private final WaehrungsView form;

    public WaehrungsPresenter(WaehrungsView form) {
        this.form = form;
        this.form.setPresenter(this);
    }

    public void calculate(String chfString, WaehrungsEnum comboBoxEnum) {
        form.setErrorLabel("");
        try {
            double intputWaehrung = Double.parseDouble(chfString);
            double waehrung = switch (comboBoxEnum) {
                case CHF -> intputWaehrung;
                case EURO -> intputWaehrung / 1.08;
                case USD -> intputWaehrung / 0.91;
                case GBP -> intputWaehrung / 1.208;
                case JPY -> intputWaehrung / 0.0088;
                case CAD -> intputWaehrung / 0.698;
                case SKR -> intputWaehrung / 0.106;
                case SAR -> intputWaehrung / 0.056;
            };
            form.setWaehrung(waehrung);
        } catch (NumberFormatException e) {
            form.setErrorLabel("Please enter a valid Number");
        }


    }

}
