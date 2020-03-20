package ohtu.kivipaperisakset;

public class KPSTekoaly extends Peli {
    
    public KPSTekoaly(IO io, Tuomari tuomari) {
		super(io, tuomari);
	}
    
    public void pelaa() {
        TekoalyYksinkertainen tekoaly = new TekoalyYksinkertainen();

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.syote();
        String tokanSiirto;

        tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("\n");

            io.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.syote();

            tokanSiirto = tekoaly.annaSiirto();
            io.print("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        lopetus();
    }

}