
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujonoTaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujonoTaulukko = new int[KAPASITEETTI];
        alustaTaulukko(lukujonoTaulukko);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        lukujonoTaulukko = new int[kapasiteetti];
        alustaTaulukko(lukujonoTaulukko);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
       
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            return;
        }
        if (kasvatuskoko < 0) {
            return;
        }
        lukujonoTaulukko = new int[kapasiteetti];
        alustaTaulukko(lukujonoTaulukko);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

    	if (kuuluu(luku)) { //luku on jo joukossa eli ei tehd� lis�yst�
    		return false;
    	} else {
            lukujonoTaulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujonoTaulukko.length == 0) {
            	lukujonoTaulukko = kopioiJaKasvataTaulukkoa(lukujonoTaulukko);
            }
            return true;
        }
    }

    public boolean kuuluu(int luku) {   	
    	for (int i : lukujonoTaulukko) {
    		if (luku == i) {
                return true;
            } 
    	}
    	return false;
    }

    private int selvitaPoistonIndeksi(int luku) {
    	int indeksi = -1;
    	for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujonoTaulukko[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                break;
            }
        }
    	return indeksi;
    }
    
    private int[] poistaLukuTaulukosta(int[] taulukko, int indeksi) {
    	int[] uusiPienempiTaulukko = new int[taulukko.length - 1]; 
    	for (int i = 0, j = 0; i < taulukko.length; i++) { 
            if (i == indeksi) { 
                continue; 
            } 
            uusiPienempiTaulukko[j++] = taulukko[i]; 
        } 
    	return uusiPienempiTaulukko;
    }
    
    public boolean poista(int luku) {
    	int poistettavaIndeksi;
    	poistettavaIndeksi = selvitaPoistonIndeksi(luku);

    	if (poistettavaIndeksi != -1) { // l�ytyy taulukosta
    		lukujonoTaulukko = poistaLukuTaulukosta(lukujonoTaulukko, poistettavaIndeksi);
    		alkioidenLkm--;
    		return true;
    	} else {
    		return false;
    	}
    }

    private int[] kopioiJaKasvataTaulukkoa(int[] vanha) {
    	int[] uusi = new int[alkioidenLkm + kasvatuskoko];
    	for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    	return uusi;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    private void alustaTaulukko(int[] taulukko) {
    	for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
    }
    
    private String lukujonoTulostustaVarten() {
    	String lukujonoTeksti = "{";
        for (int i = 0; i < alkioidenLkm-1; i++) {
            lukujonoTeksti += lukujonoTaulukko[i];
            lukujonoTeksti += ", ";
        }
        lukujonoTeksti += lukujonoTaulukko[alkioidenLkm - 1];
        lukujonoTeksti += "}";
        return lukujonoTeksti;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujonoTaulukko[0] + "}";
        } else {
            return lukujonoTulostustaVarten();
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujonoTaulukko[i];
        }
        return taulu;
    }
   
    static void lisaaJoukkoon(IntJoukko joukko, IntJoukko lisays) {
    	int[] lisattava = lisays.toIntArray();
        for (int i = 0; i < lisattava.length; i++) {
            joukko.lisaa(lisattava[i]);
        }
    }
    
    static void poistaJoukosta(IntJoukko joukko, IntJoukko poisto) {
    	int[] poistettava = poisto.toIntArray();
        for (int i = 0; i < poistettava.length; i++) {
            joukko.poista(poistettava[i]);
        }
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        lisaaJoukkoon(yhdiste, a);
        lisaaJoukkoon(yhdiste, b);
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        lisaaJoukkoon(erotus, a);
        poistaJoukosta(erotus, b);
        return erotus;
    }
        
}
