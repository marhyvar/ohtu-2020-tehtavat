package ohtuesimerkki;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

	Reader readerStub = new Reader() {
		 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajanNimi() {
    	Player pelaaja = stats.search("Kurri");
    	assertEquals("Kurri", pelaaja.getName());
    }
    
    @Test
    public void pelaajaaEiOle() {
    	Player pelaaja = stats.search("Kakko");
    	assertEquals(null, pelaaja);
    }
    
    @Test
    public void pelaajatJoukkueenMukaan() {
    	List<Player> lista = stats.team("EDM");
    	assertEquals("EDM", lista.get(0).getTeam());
    }
    
    @Test
    public void huippuPelaajat() {
    	List<Player> lista = stats.topScorers(3);
    	assertEquals((35+89), lista.get(0).getPoints());
    }
}
