package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    void suorita() {
        this.edellinen = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("0");
        nollaa.setDisable(true);
    }

    @Override
    void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + this.edellinen);
        nollaa.setDisable(false);;
    }
}
