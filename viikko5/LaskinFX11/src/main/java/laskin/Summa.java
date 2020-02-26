package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
	
	private TextField tuloskentta; 
    private TextField syotekentta; 
    private Sovelluslogiikka sovellus;
    private Button nollaa;
    private Button undo;
	
	public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.nollaa = nollaa;
		this.undo = undo;
		this.sovellus = sovellus;
	}

	@Override
	public void suorita() {
		int arvo = 0;		 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
	}

	@Override
	public void peru() {
		// TODO Auto-generated method stub
		
	}
}
