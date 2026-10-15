package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlienTest {
    @Test
    public void testCajaNegraAlienCreado(){
        int x = 2;
        int y = 7;
        Alien alien = new Alien(x,y);
        assertNotNull(alien, "Alien should be created succesfully");
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }
}
