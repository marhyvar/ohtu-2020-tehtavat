package ohtu.kivipaperisakset;

public class PeliTehdas {
    
    private IO io;
    
    public PeliTehdas(IO io) {
    	this.io = io;
    }
    
	public static Peli luoKaksinPeli(IO io, Tuomari tuomari) {
		return  new KPSPelaajaVsPelaaja(io, tuomari);
	}
	
	public static Peli luoPeliTekoalyaVastaan(IO io, Tuomari tuomari, TekoAly tekoaly) {
		return new KPSPelaajaVsTekoaly(io, tuomari, tekoaly);
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
                Peli kaksinpeli = PeliTehdas.luoKaksinPeli(io, new TuomariImpl());
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli yksinpeli = PeliTehdas.luoPeliTekoalyaVastaan(io, new TuomariImpl(), new TekoalyYksinkertainen());
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Peli pahaYksinpeli = PeliTehdas.luoPeliTekoalyaVastaan(io, new TuomariImpl(), new TekoalyParannettu(20));
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }
	}
    
}
