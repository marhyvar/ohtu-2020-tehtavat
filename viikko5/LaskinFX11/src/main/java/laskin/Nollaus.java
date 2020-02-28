package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Komento {
	
	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(syotekentta, syotekentta, nollaa, undo, sovellus);
	}

	@Override
	public void suorita() {
        sovellus.nollaa();
        kasitteleLasku();
	}

}
