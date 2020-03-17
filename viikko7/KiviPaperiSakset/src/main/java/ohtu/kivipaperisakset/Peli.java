package ohtu.kivipaperisakset;

public class Peli {
    
    private IO io;

	public Peli(IO io) {
		this.io = io;
	}
    
	public void aloita() {
		while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.syote();
            if (vastaus.endsWith("a")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSTekoaly yksinpeli = new KPSTekoaly();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }
	}
    
}
