package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
	int edellinen;
		
	public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, nollaa, undo, sovellus);
	}

	@Override
	public void suorita() {
		int arvo = 0;		 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        edellinen = arvo;
        kasitteleLasku();
	}

	@Override
	public void peru() {
		// TODO Auto-generated method stub
		sovellus.miinus(edellinen);
		syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
		undo.disableProperty().set(true);
	}
}
