package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {

	public KPSPelaajaVsPelaaja(IO io, Tuomari tuomari) {
		super(io, tuomari);
	}
	
    public void pelaa() {
    	String ekanSiirto, tokanSiirto;

    	do {
	        ekanSiirto = pelaajanSiirto("Ensimmäisen ");
	        if (!onkoOkSiirto(ekanSiirto)) {
	        	break;
	        }
	        tokanSiirto = pelaajanSiirto("Toisen ");
	        if (!onkoOkSiirto(tokanSiirto)) {
	        	break;
	        }
	        
	        tuomaroi(ekanSiirto, tokanSiirto);
	        
    	} while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));

        lopetus();
    }

}