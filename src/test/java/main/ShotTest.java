package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Shot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShotTest {

    @Test
    public void testCajaNegraShotCreado(){
        int x = 2;
        int y = 7;
        Shot shot = new Shot(x,y);
        assertNotNull(shot, "Shot should be created succesfully");
    }

    @Test
    public void testCajaNegraShotCreado2(){
        Shot shot = new Shot();
        assertNotNull(shot, "Shot should be created succesfully");
    }
}
