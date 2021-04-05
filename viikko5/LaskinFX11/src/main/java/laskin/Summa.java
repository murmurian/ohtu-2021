package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    void suorita() {
        int syote = Integer.parseInt(syotekentta.getText());
        this.edellinen = syote;
        sovellus.plus(syote);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());        
        nollaa.setDisable(false);  
    }

    @Override
    void peru() {
        sovellus.miinus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
