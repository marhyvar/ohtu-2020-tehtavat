package ohtu.kivipaperisakset;

public abstract class PeliMoodi {
	protected IO io;
	public PeliMoodi(IO io) {
		this.io = io;
	}
	protected abstract void pelaa();
}
