package main;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        Component source = new Button();
        Player p = new Player();
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
    public void testCajaNegraKeyPressed1() throws NoSuchFieldException, IllegalAccessException {
        Component source = new Button();
        Player p = new Player();

        try {
            int dxExpected = -2;
            KeyEvent eventIzquierda = new KeyEvent(
                    source,
                    KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_LEFT,
                    KeyEvent.CHAR_UNDEFINED
            );
            p.keyPressed(eventIzquierda);

            Field valDx = Sprite.class.getDeclaredField("dx");
            valDx.setAccessible(true);
            int valorDx = (int) valDx.get(p);

            assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
            System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);
            p.keyReleased(eventIzquierda);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testCajaNegraKeyPressed2() throws NoSuchFieldException, IllegalAccessException {
        Component source = new Button();
        Player p = new Player();
        try{
            int dxExpected = 2;
            KeyEvent eventKeyIncorrect = new KeyEvent(
                    source,
                    KeyEvent.KEY_PRESSED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_RIGHT,
                    KeyEvent.CHAR_UNDEFINED
            );
            p.keyPressed(eventKeyIncorrect);

            Field valDx = Sprite.class.getDeclaredField("dx");
            valDx.setAccessible(true);
            int valorDx = (int) valDx.get(p);

            assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
            System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);
            p.keyReleased(eventKeyIncorrect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCajaNegraKeyPressed3() throws NoSuchFieldException, IllegalAccessException {
        Component source = new Button();
        Player p = new Player();
        int dxExpected = 0;
        KeyEvent eventKeyIncorrect = new KeyEvent(
                source,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_SPACE,
                KeyEvent.CHAR_UNDEFINED
        );
        p.keyPressed(eventKeyIncorrect);

        Field valDx = Sprite.class.getDeclaredField("dx");
        valDx.setAccessible(true);
        int valorDx = (int) valDx.get(p);

        assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
        System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);
        p.keyReleased(eventKeyIncorrect);
    }


    @Test
    public void testCajaNegrakeyReleased1() {
        Component source = new Button();
        Player p = new Player();

        try {
            int dxExpected = 2;
            KeyEvent eventIzquierda = new KeyEvent(
                    source,
                    KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_LEFT,
                    KeyEvent.CHAR_UNDEFINED
            );
            p.keyReleased(eventIzquierda);

            Field valDx = Sprite.class.getDeclaredField("dx");
            valDx.setAccessible(true);
            int valorDx = (int) valDx.get(p);

            assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
            System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCajaNegrakeyReleased2() {
        Component source = new Button();
        Player p = new Player();

        try {

            int dxExpected = 0;
            KeyEvent eventDerecha = new KeyEvent(
                    source,
                    KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_RIGHT,
                    KeyEvent.CHAR_UNDEFINED
            );
            p.keyReleased(eventDerecha);

            Field valDx = Sprite.class.getDeclaredField("dx");
            valDx.setAccessible(true);
            int valorDx = (int) valDx.get(p);

            assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
            System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCajaNegrakeyReleased3() {
        Component source = new Button();
        Player p = new Player();

        try {
            int dxExpected = 0;
            KeyEvent eventKeyIncorrect = new KeyEvent(
                    source,
                    KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(),
                    0,
                    KeyEvent.VK_SPACE,
                    KeyEvent.CHAR_UNDEFINED
            );
            p.keyReleased(eventKeyIncorrect);

            Field valDx = Sprite.class.getDeclaredField("dx");
            valDx.setAccessible(true);
            int valorDx = (int) valDx.get(p);

            assertEquals(dxExpected, valorDx, "El experado: " + dxExpected + " y el dado es: " + valorDx);
            System.out.println("El experado: " + dxExpected + " y el dado es: " + valorDx);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
