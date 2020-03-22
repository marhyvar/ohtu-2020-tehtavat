package ohtu.kivipaperisakset;

public abstract class Peli {
	protected IO io;
	protected Tuomari tuomari;
	protected Tekoaly tekoaly;
	
	public Peli(IO io, Tuomari tuomari) {
		this.io = io;
		this.tuomari = tuomari;
	}
	
	public Peli(IO io, Tuomari tuomari, Tekoaly tekoaly) {
		this.io = io;
		this.tuomari = tuomari;
		this.tekoaly = tekoaly;
	}
	
	protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
	
	protected void aloitus() {
		io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
	}
	
	protected String pelaajanSiirto(String teksti) {
		String pelaaja;
		io.print(teksti + " pelaajan siirto: ");
        pelaaja = io.syote();
		return pelaaja;
	}
	
	protected void tuomaroi(String eka, String toka) {
		tuomari.kirjaaSiirto(eka, toka);
        io.print(tuomari.toString());
        io.print("\n");
	}
	
	protected void lopetus() {
		io.print("\n");
        io.print("Kiitos!");
        io.print(tuomari.toString());
	}
	
	protected abstract void pelaa();
}
