package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {

	public KPSPelaajaVsPelaaja(IO io, Tuomari tuomari) {
		super(io, tuomari);
	}
	
    public void pelaa() {
    	String ekanSiirto, tokanSiirto;
    	do {
	        io.print("Ensimmäisen pelaajan siirto: ");
	        ekanSiirto = io.syote();
	        if (!onkoOkSiirto(ekanSiirto)) {
	        	break;
	        }
	        io.print("Toisen pelaajan siirto: ");
	        tokanSiirto = io.syote();
	        if (!onkoOkSiirto(ekanSiirto)) {
	        	break;
	        }
	        
	        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
	        io.print(tuomari.toString());
	        io.print("\n");
    	} while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));

        lopetus();
    }

}