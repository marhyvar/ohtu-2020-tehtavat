package ohtu.kivipaperisakset;

public abstract class Peli {
	protected IO io;
	protected Tuomari tuomari;
	protected TekoAly tekoaly;
	
	public Peli(IO io, Tuomari tuomari) {
		this.io = io;
		this.tuomari = tuomari;
	}
	
	public Peli(IO io, Tuomari tuomari, TekoAly tekoaly) {
		this.io = io;
		this.tuomari = tuomari;
		this.tekoaly = tekoaly;
	}
	
	protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
	
	protected void lopetus() {
		io.print("\n");
        io.print("Kiitos!");
        io.print(tuomari.toString());
	}
	
	protected abstract void pelaa();
}
