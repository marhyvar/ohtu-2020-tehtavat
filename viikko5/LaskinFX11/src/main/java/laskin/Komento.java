package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
	
	protected TextField tuloskentta; 
    protected TextField syotekentta; 
    protected Sovelluslogiikka sovellus;
    protected Button nollaa;
    protected Button undo;
	
	public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
		this.tuloskentta = tuloskentta;
		this.syotekentta = syotekentta;
		this.nollaa = nollaa;
		this.undo = undo;
		this.sovellus = sovellus;
	}
	
	public void kasitteleLasku() {
		int laskunTulos = sovellus.tulos();       
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        System.out.println("Tuloskentassa tulos: " + tuloskentta.getText());
        System.out.println("Syotekentta pitäisi olla tyhja: " + syotekentta.getText());
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
	}
	
	public abstract void suorita();
	public abstract void peru();
}
