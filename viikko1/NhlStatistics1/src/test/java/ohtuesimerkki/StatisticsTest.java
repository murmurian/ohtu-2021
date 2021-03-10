package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchFindsPlayer() {
        String player = stats.search("Yzerman").getName();
        assertEquals("Yzerman", player);
    }

    @Test
    public void searchReturnsNull() {
        assertNull(stats.search("Teppo"));
    }

    @Test
    public void teamReturnsTeam() {
        List<Player> team = stats.team("EDM");        
        assertEquals("Semenko", team.get(0).getName());
        assertEquals("Kurri", team.get(1).getName());
        assertEquals("Gretzky", team.get(2).getName());
    }

    @Test
    public void topScorersIsSorted() {
        List<Player> topScorers = stats.topScorers(3);
        assertEquals("Gretzky", topScorers.get(0).getName());
        assertEquals("Lemieux", topScorers.get(1).getName());
        assertEquals("Yzerman", topScorers.get(2).getName());
    }
}