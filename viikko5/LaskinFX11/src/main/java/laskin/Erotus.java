package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {
    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    void suorita() {
        int syote = Integer.parseInt(syotekentta.getText());
        this.edellinen = syote;
        sovellus.miinus(syote);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        nollaa.setDisable(false);  
    }

    @Override
    void peru() {
        sovellus.plus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
}
