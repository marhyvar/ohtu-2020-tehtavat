package ohtu.kivipaperisakset;

import java.util.HashMap;

public class PeliTehdas {
    
    private IO io;
    private HashMap<String, Peli> pelit;
    
    public PeliTehdas(IO io) {
    	this.io = io;
    	pelit = new HashMap<String, Peli>();
    	pelit.put("a", PeliTehdas.luoKaksinPeli(io, new TuomariImpl()));
    	pelit.put("b", PeliTehdas.luoPeliTekoalyaVastaan(io, new TuomariImpl(), new TekoalyYksinkertainen()));
    	pelit.put("c", PeliTehdas.luoPeliTekoalyaVastaan(io, new TuomariImpl(), new TekoalyParannettu(20)));
    }
    
	public static Peli luoKaksinPeli(IO io, Tuomari tuomari) {
		return  new KPSPelaajaVsPelaaja(io, tuomari);
	}
	
	public static Peli luoPeliTekoalyaVastaan(IO io, Tuomari tuomari, Tekoaly tekoaly) {
		return new KPSPelaajaVsTekoaly(io, tuomari, tekoaly);
	}
	
	public void aloita() {
		while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String valinta = io.syote();
            if (valinta.equalsIgnoreCase("a") || valinta.equalsIgnoreCase("b") || valinta.equalsIgnoreCase("c")) {
            	io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            	pelit.get(valinta).pelaa();
            } else {
            	break;
            }

        }
	}
    
}
