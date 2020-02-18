package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
	
	Pankki pankki;
	Viitegeneraattori viite;
	Varasto varasto;
	
	@Before
	public void setUp() {
	    pankki = mock(Pankki.class);
	    viite = mock(Viitegeneraattori.class);
	    varasto = mock(Varasto.class);
	}
	
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        // m‰‰ritell‰‰n ett‰ viitegeneraattori palauttaa viitteen 42
        when(viite.uusi()).thenReturn(42);

        // m‰‰ritell‰‰n ett‰ tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

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
    	
    	// m‰‰ritell‰‰n ett‰ viitegeneraattori palauttaa viitteen 42
        when(viite.uusi()).thenReturn(42);

        // m‰‰ritell‰‰n ett‰ tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehd‰‰n ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, ett‰ pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), anyString(), anyString(), eq(5)); 
    }
}


