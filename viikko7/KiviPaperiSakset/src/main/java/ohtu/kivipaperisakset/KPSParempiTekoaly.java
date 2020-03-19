package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Peli {
	
	public KPSParempiTekoaly(IO io, Tuomari tuomari) {
		super(io, tuomari);
	}

    public void pelaa() {
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);

        io.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = io.syote();
        String tokanSiirto;


        tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);


        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            io.print("\n");

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = io.syote();

            tokanSiirto = tekoaly.annaSiirto();
            io.print("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }

        lopetus();
    }

}
