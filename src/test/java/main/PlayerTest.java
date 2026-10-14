package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    //public Player() --> casos especiales (si se crea o no el objeto)
    @Test
    public void creacionPlayer() {
        Player player = new Player();
        assertNotNull(player, "Player should be created succesfully");

    }

}
