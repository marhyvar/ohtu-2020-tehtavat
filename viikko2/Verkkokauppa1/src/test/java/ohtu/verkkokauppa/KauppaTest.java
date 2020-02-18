package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
	
	Pankki pankki;
	Viitegeneraattori viite;
	Varasto varasto;
	Kauppa k;
	
	@Before
	public void setUp() {
	    pankki = mock(Pankki.class);
	    viite = mock(Viitegeneraattori.class);
	    varasto = mock(Varasto.class);
	    k = new Kauppa(varasto, pankki, viite);
	    
        // m‰‰ritell‰‰n ett‰ viitegeneraattori palauttaa viitteen 42
        when(viite.uusi()).thenReturn(42);
        
        // m‰‰ritell‰‰n ett‰ tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        //m‰‰ritell‰‰n ett‰ tuote numero 2 on juusto jonka hinta on 10 ja saldo 10
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "juusto", 10));
        
      //m‰‰ritell‰‰n ett‰ tuote numero 3 on voi jonka hinta on 2 ja saldo 0
        when(varasto.saldo(3)).thenReturn(0); 
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "voi", 2));
	}
	
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
               
        // tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei v‰litetty kutsussa k‰ytetyist‰ parametreista
    }
    
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {

        // tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5)); 
    }
    
    @Test
    public void kahdenTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
    	// tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli juustoa
        k.tilimaksu("pekka", "12345");
        
        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(15));
    }
    
    @Test
    public void kahdenSamanTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
    	// tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
        
        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));
    }
    
    @Test
    public void varastostaLoppuneenTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
    	// tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa, jonka hinta on 5
        k.lisaaKoriin(3);     // ostetaan tuotetta numero 3 eli voita, joka on loppu varastosta
        k.tilimaksu("pekka", "12345");
        
        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }
}


