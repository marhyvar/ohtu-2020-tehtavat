package ohtu.verkkokauppa;

public class Viitegeneraattori implements IOviitegeneraattori {

    private static IOviitegeneraattori instanssi;

    public static IOviitegeneraattori getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }
    
    private int seuraava;
    
    private Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
	public int uusi(){
        return seuraava++;
    }
}
