package ohtu.matkakortti;

public class Kassapaate {
    private int myytyjaLounaita;
    public static final int HINTA = 5;

    public Kassapaate() {
        this.myytyjaLounaita = 0;
    }
    
    public void lataa(Maksukortti kortti, int summa){
        kortti.lataa(summa);
    }
    
    public void ostaLounas(Maksukortti kortti) {
    	if (kortti.getSaldo() >= 5) {
    		kortti.osta(HINTA);
            myytyjaLounaita++;
    	} else {
    		return;
    	}
        
    }

    public int getMyytyjaLounaita() {
        return myytyjaLounaita;
    }
}
