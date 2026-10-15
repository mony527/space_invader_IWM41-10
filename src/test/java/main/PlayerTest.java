package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;
import space_invaders.sprites.Sprite;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class PlayerTest {

    //public Player() --> casos especiales (si se crea o no el objeto)
    @Test
    public void creacionPlayer() {
        Player player = new Player();
        assertNotNull(player, "Player should be created succesfully");

    }
    //public initPlayer --> casos especiales (si esta en las coordenadas iniciales)
    @Test
    public void inicializarPlayer() {
        Player player = new Player();
        try{
            Method metodo = Player.class.getDeclaredMethod("initPlayer");
            metodo.setAccessible(true);
            metodo.invoke(player);

            Field valX = Player.class.getDeclaredField("x");
            valX.setAccessible(true);
            int valorX = (int) valX.get(player);
            Field valy = Player.class.getDeclaredField("y");
            valy.setAccessible(true);
            int valorY = (int) valy.get(player);

            int xInicial = Commons.BOARD_WIDTH / 2;
            int yInicial = Commons.GROUND + 10;

            assertEquals(xInicial, valorX, "La posición X no es la mitad del ancho del tablero");
            assertEquals(yInicial, valorY, "La posición Y no está 10px sobre el suelo del tablero");

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }

}
