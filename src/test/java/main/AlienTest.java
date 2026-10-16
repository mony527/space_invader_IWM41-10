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

    @Test
    public void testCajaNegraAlienInicializado1(){
        int x = 150;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado2(){
        int x = 150;
        int y = 0;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado3(){
        int x = 150;
        int y = 1;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado4(){
        int x = 150;
        int y = 357;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado5(){
        int x = 150;
        int y = 358;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado6(){
        int x = 150;
        int y = -1;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(0, alien.getY(), "Alien y should be "+0);
    }

    @Test
    public void testCajaNegraAlienInicializado7(){
        int x = 150;
        int y = 359;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(358, alien.getY(), "Alien y should be "+358);
    }

    @Test
    public void testCajaNegraAlienInicializado8(){
        int x = 0;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado9(){
        int x = 1;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado10(){
        int x = 349;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }
    @Test
    public void testCajaNegraAlienInicializado11(){
        int x = 350;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(x, alien.getX(), "Alien x should be "+x);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado12(){
        int x = -1;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(0, alien.getX(), "Alien x should be "+0);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }

    @Test
    public void testCajaNegraAlienInicializado13(){
        int x = 351;
        int y = 5;
        Alien alien = new Alien(x, y);
        assertEquals(350, alien.getX(), "Alien x should be "+350);
        assertEquals(y, alien.getY(), "Alien y should be "+y);
    }
}
