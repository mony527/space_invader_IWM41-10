package main;

import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;
import space_invaders.sprites.Sprite;
import java.awt.Component;
import java.awt.Button; // O cualquier otro Component (o un mock)
import java.awt.event.KeyEvent;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testCajaNegraKeyPressed() {
        Component source = new Button();
        List<Integer> validos = List.of(37,39);

        KeyEvent eventIzquierda = new KeyEvent(
                source,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_LEFT,
                KeyEvent.CHAR_UNDEFINED
        );
        int keyCode = eventIzquierda.getKeyCode();
        String nombreTecla = KeyEvent.getKeyText(keyCode);

        assertTrue(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, pulse derecha o izquierda. ");

        KeyEvent eventDerecha = new KeyEvent(
                source,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        keyCode = eventDerecha.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);

        assertTrue(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, pulse derecha o izquierda. ");

        KeyEvent eventArriba = new KeyEvent(
                source,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UP,
                KeyEvent.CHAR_UNDEFINED
        );

        keyCode = eventArriba.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);

        assertFalse(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, pulse derecha o izquierda. ");


        KeyEvent eventEspacio = new KeyEvent(
                source,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_SPACE,
                KeyEvent.CHAR_UNDEFINED
        );

        keyCode = eventEspacio.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);
        assertFalse(validos.contains(keyCode),
                "Error: La tecla con codigo'" + nombreTecla + "' no es una tecla valida, pulse derecha o izquierda. ");

    }

    @Test
    public void testCajaNegrakeyReleased() {
        Component source = new Button();
        List<Integer> validos = List.of(37,39);

        KeyEvent eventIzquierda = new KeyEvent(
                source,
                KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_LEFT,
                KeyEvent.CHAR_UNDEFINED
        );
        int keyCode = eventIzquierda.getKeyCode();
        String nombreTecla = KeyEvent.getKeyText(keyCode);

        assertTrue(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, solo se permite derecha o izquierda.");

        KeyEvent eventDerecha = new KeyEvent(
                source,
                KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        keyCode = eventDerecha.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);

        assertTrue(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, solo se permite derecha o izquierda.");

        KeyEvent eventArriba = new KeyEvent(
                source,
                KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UP,
                KeyEvent.CHAR_UNDEFINED
        );

        keyCode = eventArriba.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);

        assertFalse(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, solo se permite derecha o izquierda.");


        KeyEvent eventEspacio = new KeyEvent(
                source,
                KeyEvent.KEY_RELEASED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_SPACE,
                KeyEvent.CHAR_UNDEFINED
        );

        keyCode = eventEspacio.getKeyCode();
        nombreTecla = KeyEvent.getKeyText(keyCode);
        assertFalse(validos.contains(keyCode),
                "Error: La tecla '" + nombreTecla + "' no es una tecla valida, solo se permite derecha o izquierda.");

    }

}
