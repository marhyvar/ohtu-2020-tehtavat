package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	
	protected TextField tuloskentta; 
    protected TextField syotekentta; 
    protected Sovelluslogiikka sovellus;
    protected Button nollaa;
    protected Button undo;
    protected String edellinen;
	
	public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.nollaa = nollaa;
		this.undo = undo;
		this.sovellus = sovellus;
	}
	
	public void kasitteleLasku() {
		edellinen = tuloskentta.getText();
		int laskunTulos = sovellus.tulos();       
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        undo.disableProperty().set(false);
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
	}
	
	public void peru() {
		syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
        undo.disableProperty().set(true);
	}
	
	public abstract void suorita();
	
}
