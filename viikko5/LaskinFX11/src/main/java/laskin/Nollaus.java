package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Komento {
	
	int edellinen;
	
	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(tuloskentta, syotekentta, nollaa, undo, sovellus);
	}

	@Override
	public void suorita() {
		edellinen = sovellus.tulos();
        sovellus.nollaa();
        kasitteleLasku();
	}

	@Override
	public void peru() {
		sovellus.plus(edellinen);
		syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
		undo.disableProperty().set(true);		
	}
}
