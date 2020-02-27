package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Komento {
	
	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(syotekentta, syotekentta, undo, undo, sovellus);
	}

	@Override
	public void suorita() {
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();       
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
	}

	@Override
	public void peru() {
		// TODO Auto-generated method stub
		
	}
}
