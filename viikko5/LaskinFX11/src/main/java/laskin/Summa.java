package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
		
	public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		super(syotekentta, syotekentta, undo, undo, sovellus);
	}

	@Override
	public void suorita() {
		int arvo = 0;		 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        kasitteleLasku();
	}

	@Override
	public void peru() {
		// TODO Auto-generated method stub
		
	}
}
