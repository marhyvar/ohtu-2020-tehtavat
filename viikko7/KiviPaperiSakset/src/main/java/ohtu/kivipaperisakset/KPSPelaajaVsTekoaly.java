package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSPelaajaVsTekoaly extends Peli {
	
	public KPSPelaajaVsTekoaly(IO io, Tuomari tuomari, Tekoaly tekoaly) {
		super(io, tuomari, tekoaly);
	}

    public void pelaa() {
    	String ekanSiirto, tokanSiirto;
        
         do {
        	io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.syote();
            if (!onkoOkSiirto(ekanSiirto)) {
	        	break;
	        }
            tokanSiirto = tekoaly.annaSiirto();
            io.print("Tietokone valitsi: " + tokanSiirto);
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            io.print("\n");
            tekoaly.asetaSiirto(ekanSiirto);

        } while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));

        lopetus();
    }

}
