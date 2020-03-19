package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {
        PeliTehdas peli = new PeliTehdas(new KonsoliIO());
        peli.aloita();
    }
}
