package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaus extends Komento {
	
	private TextField tuloskentta; 
    private TextField syotekentta; 
    private Sovelluslogiikka sovellus;
    private Button nollaa;
    private Button undo;
	
	public Nollaus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.nollaa = nollaa;
		this.undo = undo;
		this.sovellus = sovellus;
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
