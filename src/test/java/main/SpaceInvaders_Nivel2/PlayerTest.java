package main.SpaceInvaders_Nivel2;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    //Test id: ActPlayerCB1
    //Camino: A-B-D-FIN
    @Test
    public void actPlayerCB1(){
        Player player = new Player();
        player.setX(10);

        try {
            Field valdx = Sprite.class.getDeclaredField("dx");
            valdx.setAccessible(true);
            int dx = (int) valdx.get(player);

            player.act();

            assertEquals(10+dx, player.getX());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Test id: ActPlayerCB2
    //Camino: A-B-C-D-FIN
    @Test
    public void actPlayerCB2(){
        Player player = new Player();
        player.setX(1);

        player.act();

        assertEquals(2, player.getX());

    }

    //Test id: ActPlayerCB3
    //Camino: A-B-D-E-FIN
    @Test
    public void actPlayerCB3(){
        Player player = new Player();
        player.setX(10740);

        player.act();

        assertEquals(328, player.getX());
    }
}
